package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.Flyable;


public class Pesawat extends Kendaraan implements Flyable {
    @Override
    public void Start() {
        System.out.println("Menyalakan mesin pesawat " + this.getModel());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getModel());
    }
    @Override
    public void Brake() {
        System.out.println("Pesawat " + this.getModel() + " Berhenti ");
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getModel() + " lepas landas");
    }
}
