package q1_MariaNascimento;

public class Main {
    public static void main(String[] args) {
        // Cria uma Company
        Company myCompany = new Company("M.Dias Branco");

        // Cria algumas instâncias de Employee
        Employee employee1 = new Employee("Maria");
        Employee employee2 = new Employee("Clara");

        // Cria alguns Vehicle
        Vehicle vehicle1 = new Vehicle("123-ABC");
        Truck truck1 = new Truck("456-DEF", 5000);
        Car car1 = new Car("789-GHI", "Automatic");

        // Contrate os funcionários
        myCompany.Employs(employee1);
        myCompany.Employs(employee2);

        // Adicione veículos à empresa
        myCompany.Hire(vehicle1);
        myCompany.Hire(truck1);
        myCompany.Hire(car1);

        // Mostrar o nome da empresa
        myCompany.CompName();

        // Mostrar os nomes dos funcionários
        employee1.EmploName();
        employee2.EmploName();

        //Atribui um veiculo a um funcionário
        employee1.Drives(car1);
        employee2.Drives(truck1);

        //Mostra o veiculo do funcionário
        employee1.WhatDrive();
        employee2.WhatDrive();
    }
}
