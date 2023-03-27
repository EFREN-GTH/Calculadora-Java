import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalculadoraEfren extends JFrame implements ActionListener {

	JButton[] digitos; //Array para los botones de digitos
	JButton sumar, restar, dividir, multiplicar, 
			igual, raiz, elevar, porcentaje, borrar, signo, coma;  
	JPanel p; //panel
	JLabel pantalla; //Resultado en pantalla
	JLabel pantallaMini;
	GridBagConstraints c = new GridBagConstraints();  //GridBagConstraints
	
	void addGB(Component component, int x, int y) {
		c.gridx = x; //posicion columna
		c.gridy = y; //posicion fila
		p.add(component, c);
	}
	void estiloOperacion(Component component) {
			component.setBackground(Color.DARK_GRAY);
	    	component.setForeground(Color.WHITE);
	    	component.setFont(new Font("Arial", Font.PLAIN, 20));
	}
	void estiloNumPad(Component component) {
		component.setBackground(Color.GRAY);
    	component.setForeground(Color.WHITE);
    	component.setFont(new Font("Arial", Font.PLAIN, 20));
	}
	CalculadoraEfren(){
		//PANEL
		p = new JPanel();
		p.setBackground(Color.BLACK); 
			//GridBagLayout(panel)
		p.setLayout(new GridBagLayout()); 
    	c.weightx = 1;
    	c.weighty = 1;
    	c.fill = GridBagConstraints.BOTH;
    	
    	//BOTONES
		//Crear los botones de digitos.
		digitos = new JButton[10];
    	for (int i=0;i<digitos.length;i++) 
    		digitos[i] = new JButton(String.valueOf(i));
		
    	//Crear los demas botones
    	sumar = new JButton("+");
    	restar = new JButton("-");
    	dividir = new JButton("÷");
    	multiplicar = new JButton("x");
    	igual = new JButton("=");
    	raiz = new JButton("\u221A");
    	elevar = new JButton("x\u00B2");
    	porcentaje = new JButton("%");
    	borrar = new JButton("C");
    	signo = new JButton("±");
    	coma = new JButton(",");
    	//Crear Pantallas
    	pantalla = new JLabel("0");
    	pantallaMini = new JLabel(" ");  
    	
    	//DISEÑO Y GRIDBAG:
    	int x, y; //posiciones (columna, fila)
    	//Pantalla mini
    	pantallaMini.setForeground(Color.WHITE); //Color Texto
    	pantallaMini.setFont(new Font("Arial", Font.ITALIC, 14)); //Tipografía
    	pantallaMini.setHorizontalAlignment(SwingConstants.RIGHT); //Alineación derecha
    	c.insets = new Insets(20,0,0,10);  //Padding
    	
    	c.gridwidth = 5; //Cuantas columnas va a ocupar  
    	c.gridheight = 1; //Cuantas columnas va a ocupar  
    	addGB(pantallaMini, x=0, y=0);//Posicion(columna, fila)
    	
    	//Pantalla
    	pantalla.setForeground(Color.DARK_GRAY);
    	pantalla.setFont(new Font("Arial", Font.BOLD, 24));
    	pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
    	c.insets = new Insets(0,0,10,10);  //Padding  
    	
    	addGB(pantalla, x=0, y=1);//Posicion(columna, fila)
   
    	//FILA 2
    	//raíz cuadrada
    	c.insets = new Insets(5,5,5,5); //Padding
    	estiloOperacion(raiz);
    	c.gridwidth = 1;
    	addGB(raiz, x=0, y=2);//Posicion(columna, fila)
    	//elevado a 
    	estiloOperacion(elevar);
    	addGB(elevar, x=1, y=2);//Posicion(columna, fila)	
    	//porcentaje 
    	estiloOperacion(porcentaje);  
    	addGB(porcentaje, x=2, y=2	);//Posicion(columna, fila)    	
    	//C borrrar todo 
    	estiloOperacion(borrar);  
    	c.gridwidth = 2; //cuantas columnas va a ocupar
    	addGB(borrar, x=3, y=2	);//Posicion(columna, fila)	
    	
    	//FILA 3
    	//NUMEROS 7,8,9  
    	for (int i=0;i<digitos.length;i++) {
    		estiloNumPad(digitos[i]);
    	}
    	c.gridwidth = 1;  
    	addGB(digitos[7], x=0, y=3	);//Posicion(columna, fila)  
    	addGB(digitos[8], x=1, y=3	);//Posicion(columna, fila)    	 
    	addGB(digitos[9], x=2, y=3	);//Posicion(columna, fila)
    	//dividir 
    	estiloOperacion(dividir); 
    	addGB(dividir, x=3, y=3	);//Posicion(columna, fila)    	
    	//multiplicar
    	estiloOperacion(multiplicar);
    	c.gridheight = 2; //cuantas filas va a ocupar (altura)
    	addGB(multiplicar, x=4, y=3	);//Posicion(columna, fila)
    	
    	//FILA 4
    	//NUMEROS 4,5 y 6 
    	c.gridheight = 1;
    	c.gridwidth = 1;  
    	addGB(digitos[4], x=0, y=4	);//Posicion(columna, fila)  
    	c.gridwidth = 1;  
    	addGB(digitos[5], x=1, y=4	);//Posicion(columna, fila)  
    	c.gridwidth = 1;  
    	addGB(digitos[6], x=2, y=4	);//Posicion(columna, fila)
    	
    	//sumar
    	estiloOperacion(sumar);
    	c.gridheight = 2; //cuantas filas va a ocupar (alto)
    	c.gridwidth = 1; //cuantas columnas va a ocupar (ancho)
    	addGB(sumar, x=3, y=4	);//Posicion(columna, fila)
    	
    	//FILA 5
    	//NUMEROS 1,2 y 3 
    	c.gridheight = 1;
    	c.gridwidth = 1; //cuantas columnas va a ocupar
    	addGB(digitos[1], x=0, y=5	);//Posicion(columna, fila)   
    	addGB(digitos[2], x=1, y=5	);//Posicion(columna, fila) 
    	addGB(digitos[3], x=2, y=5	);//Posicion(columna, fila)
    	//restar 
    	estiloOperacion(restar);
    	addGB(restar, x=4, y=5	);//Posicion(columna, fila)
    	
    	//FILA 6
    	//signo
    	estiloNumPad(signo);
    	c.gridwidth = 1;  
    	addGB(signo, x=0, y=6	);//Posicion(columna, fila)    	
    	 //Cero 
    	addGB(digitos[0], x=1, y=6	);//Posicion(columna, fila)   	 
    	//coma
    	estiloNumPad(coma); 
    	addGB(coma, x=2, y=6	);//Posicion(columna, fila)   	  
    	//Igual  
    	igual.setBackground(Color.ORANGE);
    	igual.setForeground(Color.WHITE);
    	igual.setFont(new Font("Arial", Font.PLAIN, 20));
    	c.gridwidth = 2;  
    	addGB(igual, x=3, y=6	);//Posicion(columna, fila)   	 
    	 
    	add(p);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    	setTitle("CalculadoraEfren");
    	setSize(350,400);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	
    	//AÑADIR ESCUCHA A LOS BOTONES:
    	//Números
    	for (int i=0;i<digitos.length;i++)
    		digitos[i].addActionListener(this);
    	//Coma
    	coma.addActionListener(this);
    	//Operaciones
    	sumar.addActionListener(this);
    	restar.addActionListener(this);
    	multiplicar.addActionListener(this);
    	dividir.addActionListener(this);
    	raiz.addActionListener(this);
    	elevar.addActionListener(this);
    	porcentaje.addActionListener(this);
    	//Igual
    	igual.addActionListener(this);
    	//Borrar
    	borrar.addActionListener(this);
    	//Signo
    	signo.addActionListener(this);
	}
	//VARIABLES PARA ACTIONLISTENER
	String operacion, primerValorString, segundoValorString, resultadoString;
	double primerValor, segundoValor;
	@Override
	public void actionPerformed(ActionEvent e) {
		escucharDigitos(e);
		escucharComa(e);
		escucharBorrar(e);
		escucharOperacion(e);
		escucharIgual(e);
		escucharSigno(e);
	}
	public void escucharDigitos(ActionEvent x) {
		for(int i=0; i<digitos.length;i++) {
			if(x.getSource()==digitos[i]) {
				pantalla.setForeground(Color.WHITE);
				if(pantalla.getText()=="0" || pantalla.getText() == primerValorString || pantalla.getText() == resultadoString
				|| pantalla.getText() == "Imposible dividir entre cero"){
					pantalla.setText("");
					pantallaMini.setText(" ");
				}	
				pantalla.setText(pantalla.getText() + String.valueOf(i));
				i = digitos.length;
			}
		}
	}
	public void escucharComa(ActionEvent x) {
		if(x.getSource()==coma && !pantalla.getText().contains(".")) {
			if(pantalla.getText() == resultadoString || pantalla.getText() == "Imposible dividir entre cero") {
				pantalla.setText("0");
				pantallaMini.setText(" ");
			}
			pantalla.setText(pantalla.getText() + ".");
			pantalla.setForeground(Color.WHITE);
		}		
	}
	public void escucharBorrar(ActionEvent x) {
		if(x.getSource()==borrar) {
			pantalla.setForeground(Color.DARK_GRAY);
			pantalla.setText("0");
			pantallaMini.setText(" ");
			operacion = null;
		}
	}
	public double getValor(){
		primerValorString = pantalla.getText();
		pantalla.setForeground(Color.DARK_GRAY);
		return Double.parseDouble(primerValorString);		
	}
	public void escucharOperacion(ActionEvent x){
		if(pantalla.getText() == primerValorString || pantallaMini.getText() == " " || pantalla.getText() == resultadoString) {
			if(x.getSource()==sumar) {
			primerValor = getValor();
			operacion = "+";
		}
		else
			if(x.getSource()==restar) {
				primerValor = getValor();
				operacion = "-";
			}				
			else
				if(x.getSource()==multiplicar) {
					primerValor = getValor();
					operacion = "x";
				}		
				else
					if(x.getSource()==dividir) {
						primerValor = getValor();
						operacion = "÷";
					}	
					else
						if(x.getSource()==raiz) {
							primerValor = getValor();
							pantallaMini.setText("\u221A" + "(" + primerValorString + ") =");
							esDecimal(Math.sqrt(primerValor));
						}
						else
							if(x.getSource()==elevar) {
								primerValor = getValor();
								pantallaMini.setText(primerValorString + "\u00B2 =");
								esDecimal(primerValor * primerValor);
							}
							else
								if(x.getSource()==porcentaje) {
									primerValor = getValor();
									operacion = "%";
								}
		}
		
		if(operacion != null)
			pantallaMini.setText(primerValorString + " " + operacion);	
	}
	public void escucharIgual(ActionEvent x) {
		if(x.getSource() == igual && pantalla.getText() != "Imposible dividir entre cero") {
			double resultado= 0;
			pantalla.setForeground(Color.WHITE);
			segundoValorString = pantalla.getText();
			segundoValor = Double.parseDouble(segundoValorString);
			if(operacion == "+") {
				resultado = primerValor + segundoValor;
				esDecimal(resultado);
				pantallaMini.setText(pantallaMini.getText() + " " + segundoValorString + " =");
			}				
			else
				if(operacion == "-") {
					resultado = primerValor - segundoValor;
					esDecimal(resultado);
					pantallaMini.setText(pantallaMini.getText() + " " + segundoValorString + " =");
				}
				else
					if(operacion == "x") {
						resultado = primerValor * segundoValor;
						esDecimal(resultado);
						pantallaMini.setText(pantallaMini.getText() + " " + segundoValorString + " =");
					}
					else
						if(operacion == "÷") {
							if(segundoValor == 0) {
								pantalla.setText("Imposible dividir entre cero");
							}
							else {
								resultado = primerValor / segundoValor;
							esDecimal(resultado);
							}
							pantallaMini.setText(pantallaMini.getText() + " " + segundoValorString + " =");
						}	
						else
							if(operacion == "%") {
								resultado = (primerValor / 100) * segundoValor;
								esDecimal(resultado);
								pantallaMini.setText(pantallaMini.getText() + " " + segundoValorString + " =");
							}
							else {
								pantallaMini.setText(pantalla.getText() + " =");
							}			
			operacion = null;
		}
	}
	public void esDecimal (double num) {
		pantalla.setForeground(Color.WHITE);
		if (num % 1 == 0) {
			resultadoString = String.valueOf((int)num);
			pantalla.setText(resultadoString);
		}
		else {
			resultadoString = String.valueOf(num);
			pantalla.setText(resultadoString);
		}
	}
	public void escucharSigno(ActionEvent x) {
		if(x.getSource() == signo && pantalla.getText() != "Imposible dividir entre cero")
			esDecimal(Double.parseDouble(pantalla.getText())*-1);
	}
	public static void main(String[] args) {
		new CalculadoraEfren();
	}

}
