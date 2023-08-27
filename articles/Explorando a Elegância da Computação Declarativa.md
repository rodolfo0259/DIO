# Explorando a Elegância da Computação Declarativa

A Programação Declarativa é como dar as direções para um destino sem se preocupar com cada passo do caminho, ela é um paradigma que descreve os resultados desejados sem listar explicitamente os comandos ou etapas que devem ser executados. Assim a ênfase está em "o que" precisa ser feito, não em "como" deve ser feito. Isso resulta em um código mais conciso e legível.

**Um Olhar em Código Imperativo:**
```python
def soma_quadrados(lista):
    soma = 0
    for i in lista:
        soma += i**2
    
    return soma

numeros = [1, 2, 3, 4, 5]
resultado = soma_quadrados(numeros)
print("A soma dos quadrados é:", resultado)
```

Neste código, iteramos sobre a lista e realizamos o processo de "como" usando um loop `for`, explicitamente calculando e somando o valor do quadrado à nossa variável `soma`.

**Um Olhar na Abordagem Declarativa:**
```python
def soma_quadrados(lista):
    return sum(map(lambda x: x ** 2, lista))

numeros = [1, 2, 3, 4, 5]
resultado = soma_quadrados(numeros)
print("A soma dos quadrados é:", resultado)
```

Neste exemplo, usamos a função `map` para aplicar uma função `lambda` a cada elemento da lista e, em seguida, usamos a função `sum` para calcular a soma dos resultados. A abordagem está mais focada na composição entre funções do que na criação de iterações explícitas, como no exemplo anterior com o uso de um loop `for`.

Outros exemplos incluem elevar apenas números pares ao quadrado.

**Forma Imperativa:**
```python
def numeros_pares_ao_quadrado(numeros):
    numeros_pares = []
    for num in numeros:
        if num % 2 == 0:
            numeros_pares.append(num ** 2)

    return numeros_pares

lista_original = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
resultado = numeros_pares_ao_quadrado(lista_original)
print("Números pares elevados ao quadrado:", resultado)
```

**Forma Declarativa:**
```python
def numeros_pares_ao_quadrado(numeros):
    numeros_pares = filter(lambda x: x % 2 == 0, numeros)
    numeros_quadrados = map(lambda x: x ** 2, numeros_pares)
    return list(numeros_quadrados)

lista_original = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
resultado = numeros_pares_ao_quadrado(lista_original)
print("Números pares elevados ao quadrado:", resultado)
```

## Conclusão:
A Programação Declarativa em Python oferece uma abordagem poderosa para criar códigos mais claros e modulares. Ao enfatizar a avaliação de funções, podemos alcançar um design de software mais previsível e fácil de manter. Embora a abordagem declarativa possa parecer complexa em alguns cenários, sua compreensão se torna mais natural à medida que os desenvolvedores se familiarizam com os conceitos. Ao escolher quando aplicar a programação declarativa e quando adotar outros paradigmas, os desenvolvedores podem aproveitar ao máximo as vantagens que cada abordagem oferece para diferentes situações.