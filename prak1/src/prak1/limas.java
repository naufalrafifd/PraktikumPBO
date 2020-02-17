/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak1;


public class limas {
    double volume(double p,double l, double t) {
        return p*l*t*0.33;
    }
    double luaspermukaan(double p,double l,double t) {
        double c = Math.sqrt(Math.pow(0.5*p,2)+ Math.pow(t, 2));//rumus Phytaghoras
        return (4*(c*l*0.5) + p*l);
    }
}
