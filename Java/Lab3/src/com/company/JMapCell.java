package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JMapCell extends JComponent        //для отображение состояния ячеек на карте
{
    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    boolean endpoint = false;       //Значение True указывает, что ячейка является либо начальной, либо конечной.

    boolean passable = true;        //Значение True указывает на то, что ячейка проходима

    boolean path = false;       //Значение True указывает, что эта ячейка является частью пути между началом и концом.

    public JMapCell(boolean pass)       //Создайте новую ячейку карты с указанной "возможностью". Ввод значения true означает, что ячейка проходима.
    {
        //Установливает предпочтительный размер ячейки
        setPreferredSize(CELL_SIZE);

        setPassable(pass);
    }

    //Создает новую ячейку карты, которая по умолчанию является проходимой.
    public JMapCell()
    {
        // Вызовите другой конструктор, указав значение true для "passable".
        this(true);
    }

    //Помечает эту ячейку либо как начальную, либо как конечную.
    public void setEndpoint(boolean end)
    {
        endpoint = end;
        updateAppearance();
    }

    public void setPassable(boolean pass)       //Устанавливает эту ячейку проходимой или непроходимой
    {
        passable = pass;
        updateAppearance();
    }


    public boolean isPassable()     //Возвращает значение true, если эта ячейка является проходимой
    {
        return passable;
    }

    public void togglePassable()        //Переключает текущее "проходимое" состояние ячейки карты.
    {
        setPassable(!isPassable());
    }

    public void setPath(boolean path)       //Помечает эту ячейку как часть пути
    {
        this.path = path;
        updateAppearance();
    }

    private void updateAppearance()     //обновляет цвет фона в соответствии с текущим внутреннее состояние ячейки
    {
        if (passable)
        {
            // Проходимая клетка
            setBackground(Color.WHITE);

            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        }
        else
        {
            // непроходимая клетка
            setBackground(Color.RED);
        }
    }

    protected void paintComponent(Graphics g)       // метод для рисования цвета фона в ячейке карты
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
