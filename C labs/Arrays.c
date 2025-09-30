print_forward_backward(int* input_array, int n_elements);
#include <stdio.h>
#include <stdlib.h>

void print_forward_backward(int* input_array, int n_elements) {
   for (int i = 0; i < n_elements; i++) {
      printf("%d ", *(input_array + i));
   }
   for (int i = n_elements - 1; i >= 0; i--) {
      printf("%d ", *(input_array + i));
   }
   
   printf("\n");
}

int main(void) {
   int intArray[] = {256,128,64};
   print_forward_backward(intArray, 3);
   print_forward_backward(intArray, 5);
   
   printf("\n");
   
   int num_elem, input_num;
   
   printf("Enter number of elements: ");
   scanf("%d", &num_elem);
   
   int* intPtr;
   
   intPtr = malloc(num_elem * sizeof(int));
   
   if (intPtr == NULL) {
      printf("Error! memort not allocated");
      exit(0);
   }
   
   for (int i = 0; i < num_elem; i++) {
      printf("Enter element %d: ", (i+1));
      scanf("%d", &input_num);
      
      *(intPtr + i) = input_num;
   }
   
   print_forward_backward(intPtr, num_elem);
   
   free(intPtr);
   
   return 0;
}