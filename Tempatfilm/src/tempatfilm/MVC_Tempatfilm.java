/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempatfilm;

public class MVC_Tempatfilm {
    ViewTempatfilm viewTempatfilm = new ViewTempatfilm();
    ModelTempatfilm modelTempatfilm = new ModelTempatfilm();
    ControllerTempatfilm controllerTempatfilm = new ControllerTempatfilm(modelTempatfilm, viewTempatfilm);
}
