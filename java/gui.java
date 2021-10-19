importar  javax.swing. * ;
importar  java.awt. * ;
importar  java.awt.event. * ;

La  interfaz gráfica de usuario de clase  pública extiende JFrame {  
    JPanel panelImage;
    JPanel panelOptions;

    JButton runAlgo;

     interfaz gráfica de usuario pública () {
        setTitle ( " algoritmo de Dijkstra " );
        setSize ( 400 , 700 );
        setLocation ( nuevo  punto ( 200 , 100 ));
        setLayout ( nuevo  GridLayout ( 2 , 2 ));
        setResizable ( falso );

        initComponent ();
        initEvent ();

    }

    private  void  initComponent () {
        esto . panelImage =  nuevo  JPanel ();
        esto . panelOptions =  new  JPanel ();

        esto . runAlgo =  new  JButton ( " Ejecutar AlgoritmoDJ " );
        esto . panelOptions . agregar (runAlgo);


        esto . panelImage . agregar ( nuevo  JLabel ( nuevo  ImageIcon ( " ./nodos.PNG " )));

        esto . agregar ( este . panelImage);
        esto . añadir ( this . panelOptions);

    }

    private  void  initEvent () {
        esto . addWindowListener ( new  WindowAdapter () {
            pública  vacío  windowsClosing ( WindowEvent  e ) {
                Sistema . fuera . println ( " [OK] Salir !!! " );
                Sistema . salida ( 1 );
            }
        });
    }
}