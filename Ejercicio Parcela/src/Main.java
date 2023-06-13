abstract class Figura {
    public abstract double area();

    public abstract double perimetro();
}

class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return (base * 2) + (altura * 2);
    }

}

class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }
}

class Circulo extends Figura {
    private double diametro;

    public Circulo(double diametro) {
        this.diametro = diametro;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.diametro/2, 2);
    }

    @Override
    public double perimetro() {
        return Math.PI * this.diametro;
    }

}

class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        double Hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
        return Hipotenusa + base + altura;
    }

    public double getAltura() {
        return altura;
    }
}


class Parcela extends Figura {
    private Figura[] figuras;

    public Parcela(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double area() {
        double resultado = 0.0;
        for (Figura figura : figuras) {
            resultado += figura.area();
        }
        return resultado;
    }

    @Override
    public double perimetro() {
        double resultado = 0.0;
        for (Figura figura : figuras) {
            resultado += figura.perimetro();
        }
        return resultado;
    }

    public double perimetroFinal(double perimetro) {
        Cuadrado cuadrado = new Cuadrado(4);
        Rectangulo rectangulo = new Rectangulo(8, 4);
        Triangulo triangulo1 = new Triangulo(2, 3);
        Triangulo triangulo2 = new Triangulo(2, 6);
        double resultado = perimetro - (cuadrado.getLado() + (cuadrado.getLado() / 2)) - (rectangulo.getBase() + rectangulo.getAltura() * 2) - triangulo1.getBase() - triangulo2.getBase();
        return resultado;
    }
}

public class Main {
    public static void main(String[] args) {
        Parcela parcela = new Parcela(new Figura[]{
                new Cuadrado(4), new Rectangulo(8, 4), new Circulo(4), new Triangulo(2, 3), new Triangulo(2, 6)
        });
        double area = parcela.area();
        double costeTotal = area * 32;
        System.out.println("Expropiar el terreno cuesta: " + costeTotal);
        double perimetro = parcela.perimetroFinal(parcela.perimetro());
        System.out.println(parcela.perimetro());
        System.out.println("El perímetro de la parcela es: " + perimetro);


    }
}