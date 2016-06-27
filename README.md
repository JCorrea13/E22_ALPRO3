# Codificação de Huffman
O algoritmo de compress ̃ao de Huffman e  ́ usado quando sabemos quantas vezes cada
caractere apararece em um arquivo que deve ser comprimido. As etapas do algoritmo s ̃ao
as seguintes:

1.- Cada par (caractere,frequencia) e  ́ colocado na raiz de uma a  ́ rvore bin ́aria que
tem apenas um elemento.
2.- As duas a  ́ rvores com menor frequencia s ̃ao escolhidas e unificadas, transformando-se
em sub ́arvore esquerda e direita de uma nova a  ́ rvore bin ́aria. A frequencia colocada na
raiz desta a  ́ rvore e  ́ a soma das frequencias das suas sub- ́arvores.
3.- O passo anterior e  ́ repetido at ́e que exista apenas uma grande a  ́ rvore bin ́aria.
4.- A codificac ̧ a  ̃ o e  ́ feita associando-se bit 0 e 1 para as ligac ̧ o  ̃ es esquerda e direita
de um nodo. O caminho da raiz at ́e um caracter d ́a codificac ̧ a  ̃ o do caracter. A
implementac ̧ a  ̃ o foi desenvolvida na linguagem Java.
