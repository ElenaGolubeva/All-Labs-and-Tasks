package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {      //исследование различных областей фрактала, путем его создания, отображения и обработки событий

    private int displaySize;        //размер экрана

    private JImageDisplay display;      //ссылка для обновления отображения в разных
    // методах в процессе вычисления фрактала

    private FractalGenerator fractal;       //ссылка на базовый класс
    // для отображения других видов фракталов в будущем

    private Rectangle2D.Double range;       //указывает диапозон комплексной плоскости, выводимой на экран

    //принимает значение размера отображения в качестве
    //аргумента, затем сохраняет это значение в соответствующем поле,
    //а также инициализирует объекты диапазона и фрактального генератора
    public FractalExplorer(int size) {

        displaySize = size;

        fractal = new Mandelbrot();     //инициализация объектов диапозона и фрактального генератора
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);

    }

    //инициализирует и размещает графический интерфейс Swing,
    public void createAndShowGUI()
    {
        //Установите фрейм для использования java.awt.BorderLayout для его содержимого
        display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");

        //отображение изображения в центре
        myframe.add(display, BorderLayout.CENTER);

        //сброс
        JButton resetButton = new JButton("Reset Display");

        //экземпляр оброботчика сброса
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);

        //добавление кнопки сброса внизу окна
        myframe.add(resetButton, BorderLayout.SOUTH);

        //экземпляр оброботчика мыши
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        //операция закрытия фрейма
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //разметка содержимого окна и запрет на изменение размера окна, сделают его видимым
        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }

    //метод для вывода фрактала на экран
    private void drawFractal()
    {       //проходит через все пиксели
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){

                //определение координат пикселя х - пиксельная координата хСoord - в пространстве фрактала
                double xCoord = fractal.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y,
                        range.y + range.height, displaySize, y);

                ////количество итераций для соответствующих координат в области отображения фрактала
                //
                int iteration = fractal.numIterations(xCoord, yCoord);

                if (iteration == -1){
                    display.drawPixel(x, y, 0);  //установка в черный цвет
                }

                else {
                    //значение цвета, основанное на количестве итераций
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    //обновление дисплея цветом для каждого пикселя
                    display.drawPixel(x, y, rgbColor);
                }

            }
        }
        //обновление JimageDisplay в соответствии c текущим изображением
        display.repaint();
    }
    //внутренний класс для обработки событий java.awt.event.ActionListener от кнопки сброса, сброс диапозона к начальному
    private class ResetHandler implements ActionListener
    {
        //сбрасывает диапазон до начального диапазона, заданного генератором, а затем перерисовывает фрактал
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }
    //класс для обработки событий MouseListener с дисплея, события от мыши
    private class MouseHandler extends MouseAdapter
    {
        //При получении события о щелчке мышью, класс должен
        //отобразить пиксельные кооринаты щелчка в область фрактала, а затем вызвать
        //метод генератора recenterAndZoomRange() с координатами, по которым
        //щелкнули, и масштабом 0.5.
        @Override
        public void mouseClicked(MouseEvent e)
        {

            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);


            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            // вызов метода генератора, по которым щелкнули, и масштабом 0.5
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            // перерисовка фрактала после того, как вы изменяется область фрактала
            drawFractal();
        }
    }

    // статический метод main() для FractalExplorer так, чтобы можно было его запустить
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();      //отображение начального представления
    }
}