package kendaraan.pribadi;

import kendaraan.Kendaraan;

public class Mobil extends Kendaraan {
    @Override
    public void Start() {
        System.out.println("Mobil " + this.getModel() + " dinyalakan");
    }

    @Override
    public void Stop() {
        System.out.println("Mobil " + this.getModel() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Mobil " + this.getModel() + " berhenti ");
    }
}
