

        public class Main {
            public static void main(String[] args) {
                // Prueba de constructores
                System.out.println("PRUEBA CONSTRUCTORES");
                Camion c1 = new Camion("2345LMN");
                System.out.println(c1);
                Camion c2 = new Camion( "8967MJS", 200, 150);
                System.out.println(c2);
                Camion c3 = new Camion("3456LKN", 300, 430);
                System.out.println(c3);
                Camion c4 = new Camion("7834LRM", 200, 150, Camion.PESO_UN_EJE);
                System.out.println(c4);
                Camion c5 = new Camion("5612MRT", 400, 600, Camion.PESO_CINCO_EJES);
                System.out.println(c5);

                // Pruebas método repostar
                System.out.println("\nPRUEBA 1 REPOSTAR");
                System.out.println(c2);
                System.out.println("Repostamos 100 litros a 1.57€/L");
                double precioRepostaje = c2.repostarCombustible(100, 1.57);
                System.out.println("El precio total del repostaje es: " + String.format("%.2f", precioRepostaje) + " euros");
                System.out.println(c2);

                System.out.println("\nPRUEBA 2 REPOSTAR");
                System.out.println(c4);
                System.out.println("Repostamos 20 litros a 1.57€/L");
                precioRepostaje = c4.repostarCombustible(20, 1.57);
                System.out.println("El precio total del repostaje es: " + String.format("%.2f", precioRepostaje) + " euros");
                System.out.println(c4);

                // Prueba realizar viaje
                System.out.println("\nPRUEBA 1 REALIZAR VIAJE");
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);
                System.out.println(c1);
                System.out.println("Realizamos viaje de 1200km");
                c1.realizarViaje(1200);
                System.out.println(c1);
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);

                System.out.println("\nPRUEBA 2 REALIZAR VIAJE");
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);
                System.out.println(c2);
                System.out.println("Realizamos viaje de 900km");
                c2.realizarViaje(900);
                System.out.println(c2);
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);

                System.out.println("\nPRUEBA 3 REALIZAR VIAJE");
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);
                System.out.println(c3);
                System.out.println("Realizamos viaje de 450km");
                c3.realizarViaje(450);
                System.out.println(c3);
                System.out.println("Kms recorridos por todos los camiones: " + Camion.kmsRecorridosTotales);

                // Prueba más antiguo
                System.out.println("\nPRUEBA 1 MÁS ANTIGUO");
                System.out.println(c2);
                System.out.println(c5);
                Camion antiguo = Camion.masAntiguo(c2, c5);
                System.out.println("De esos dos, el camión más antiguo es: " + antiguo.getId());

                System.out.println("\nPRUEBA 2 MÁS ANTIGUO");
                System.out.println(c1);
                System.out.println(c3);
                antiguo = Camion.masAntiguo(c1, c3);
                System.out.println("De esos dos, el camión más antiguo es: " + antiguo.getId());


            }
        }
