/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmerzamannow.spring.core.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author acer
 */
@Data
@AllArgsConstructor
public class CyclicB {
    private CyclicC cyclicC;
}
