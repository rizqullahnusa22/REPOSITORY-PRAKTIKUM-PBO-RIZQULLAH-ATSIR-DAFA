package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.ShootAble;

public  class Tank extends Kendaraan implements ShootAble {
    @Override
    public void Start() {
        System.out.println("Menyalakan tank " + this.getModel());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getModel());
    }

    @Override
    public void Brake() {
        System.out.println("Tank " + this.getModel() + " Berhenti ");
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank " + this.getModel() + " menembak " + vehicle);
    }

}
