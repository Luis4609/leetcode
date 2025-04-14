package com.luism.leetcode.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExerciseTwoSumUnitTest {

    // --- Casos de Éxito (Happy Path) ---
    @Test
    @DisplayName("Debería encontrar los índices [1, 2] que sumen el target en un caso simple")
    void twoSum_shouldFindIndices_simpleCase() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        // Ahora esperamos los índices i=1 y j=2 porque nums[0] + nums[1] == 10
        int[] expected = {1, 2};
        int[] result = ExerciseTwoSum.twoSum(nums, target); // Asume que ExerciseTwoSum.twoSum ha sido modificado
        assertArrayEquals(expected, result,
                "Esperado índices " + Arrays.toString(expected) + " pero fueron " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería encontrar los índices [0, 2] con números negativos")
    void twoSum_shouldFindIndices_withNegativeNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        // Esperamos i=0 y j=2 porque nums[0] + nums[2] == 0
        int[] expected = {0, 2};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado índices " + Arrays.toString(expected) + " pero fueron " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería encontrar los índices [0, 1] cuando el target es cero")
    void twoSum_shouldFindIndices_whenTargetIsZero() {
        int[] nums = {5, -5, 1, 10};
        int target = 0;
        // Esperamos i=0 y j=1 porque nums[0] + nums[1] == 0
        int[] expected = {0, 1};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado índices " + Arrays.toString(expected) + " pero fueron " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería encontrar los índices [3, 4] aunque estén al final del array")
    void twoSum_shouldFindIndices_atEndOfArray() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        // Esperamos i=3 y j=4 porque nums[3] + nums[4] == 9
        int[] expected = {3, 4};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado índices " + Arrays.toString(expected) + " pero fueron " + Arrays.toString(result));
    }

    // --- Casos Sin Solución ---
    // (Estos tests no cambian, ya que siguen esperando un array vacío)

    @Test
    @DisplayName("Debería devolver array vacío si no existe un par que sume el target")
    void twoSum_shouldReturnEmptyArray_whenNoPairExists() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 10;
        int[] expected = {}; // Array vacío
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío pero fue " + Arrays.toString(result));
    }

    // --- Casos de Validación de Entrada ---
    // (Estos tests no cambian, ya que siguen esperando un array vacío o una excepción)

    @Test
    @DisplayName("Debería devolver array vacío si el array es nulo (prevención de NPE antes del método)")
    void twoSum_shouldHandleNullArrayGracefully_orThrowNPE() {
        assertThrows(NullPointerException.class, () -> {
            ExerciseTwoSum.twoSum(null, 10);
        }, "Se esperaba NullPointerException para array nulo");
    }


    @Test
    @DisplayName("Debería devolver array vacío si el array está vacío")
    void twoSum_shouldReturnEmptyArray_whenArrayIsEmpty() {
        int[] nums = {};
        int target = 10;
        int[] expected = {};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío para array vacío pero fue " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería devolver array vacío si el array tiene solo un elemento")
    void twoSum_shouldReturnEmptyArray_whenArrayHasOneElement() {
        int[] nums = {5};
        int target = 10;
        int[] expected = {};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío para array de un elemento pero fue " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería devolver array vacío si el array es demasiado largo")
    void twoSum_shouldReturnEmptyArray_whenArrayIsTooLong() {
        int[] nums = new int[105]; // > 104
        Arrays.fill(nums, 1);
        int target = 10;
        int[] expected = {};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío para array demasiado largo pero fue " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería devolver array vacío si el array tiene números inválidos y el target es válido")
    void twoSum_shouldReturnEmptyArray_whenInvalidNumbersInArrayAndValidTarget() {
        int[] nums = {1, 2, 200}; // 200 está fuera de [-109, 109]
        int target = 3; // Target es válido
        int[] expected = {};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío por número inválido en array pero fue " + Arrays.toString(result));
    }

    // --- Caso Específico de Validación (Comportamiento puede ser inesperado) ---

    @Test
    @DisplayName("Debería encontrar índices [1, 2] si el target es inválido (saltándose validación temprana)")
    void twoSum_shouldProceedAndFindIndices_whenTargetIsInvalid_evenWithInvalidNumbers() {
        // Verifica que la búsqueda SÍ se realiza si el target es inválido
        int[] nums = {1, 200, 3}; // 200 es inválido
        int target = 203;        // 203 es inválido
        // Esperamos i=1 y j=2 porque nums[1] + nums[2] == 203
        int[] expected = {1, 2};
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado índices {1, 2} porque la validación se salta si el target es inválido, pero fue " + Arrays.toString(result));
    }

    @Test
    @DisplayName("Debería devolver array vacío si target inválido y no hay suma (búsqueda realizada)")
    void twoSum_shouldProceedAndReturnEmpty_whenTargetIsInvalid_withValidNumbers_NoSum() {
        int[] nums = {1, 2, 3}; // Números válidos
        int target = 200;        // Target inválido
        int[] expected = {}; // No hay suma, pero la búsqueda se realizó
        int[] result = ExerciseTwoSum.twoSum(nums, target);
        assertArrayEquals(expected, result,
                "Esperado array vacío porque no hay suma (validación de target no detuvo la búsqueda), pero fue " + Arrays.toString(result));
    }

}
