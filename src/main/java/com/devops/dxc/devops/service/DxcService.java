package com.devops.dxc.devops.service;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Util;

public class DxcService {

    public Dxc calcularDxc(int ahorro, int sueldo){

        Dxc dxc = new Dxc(sueldo, ahorro);
        dxc.setDxc(Util.getDxc(ahorro));
        dxc.setSaldo(Util.getSaldo(ahorro, dxc.getDxc()));
        dxc.setImpuesto(Util.getImpuesto(sueldo));

        return dxc;
    }
}
