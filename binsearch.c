#include <stdio.h>
#include <stdlib.h>

int binsearch(int array[], size_t start, size_t end, int el) {
	int half = start + (end-start)/2;

	if ( array[half] == el )
		return half;
	if ( start == end )
		return -1;

	if ( array[half] > el )
		return binsearch(array, 0, half-1, el);
	else
		return binsearch(array, half+1, end, el);
}

int main ( int argc, char **argv ) { 
	if ( argc == 1 ) 
		return -1;
	int i;
	int el = argc;
	int array[argc-1];
	printf("argc and number to look for: %d\n", argc);
	for ( i = 0 ; i < argc-1 ; i++ )
		array[i] = atoi(argv[i+1]);

	printf("array (must be sorted): ");
	for ( i = 0 ; i < argc-1 ; i++ )
		printf("%d ", array[i]);
	printf("\n");

	printf("end: %d\n", argc-2);

	/* here core */
	int ret = binsearch(array, 0, argc-2, el);
	if ( ret == -1 )
		printf("not found\n");
	else
		printf("found at %d\n", ret);

	return 0;
}
