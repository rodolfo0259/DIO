# Crie Testes Unitários e valide seu código!

Criação de testes unitários simples utilizando Pytest para validar e conferir seu código 

Código usado como exemplo:
```python
def is_prime(number: int) -> bool:
    '''
    Retorna se o numero é primo
    '''
    for i in range(2, int(number**0.5+1)):
        if number % i == 0:
            return False
    
    return True

def is_divisible(number: int) -> list:
    '''
    Encontra todos os números naturais que podem dividir o número de entrada
    '''
    can_divide = []
    for div in range(1, int(number**0.5+1)):
        if number % div == 0:
            can_divide.append(div)
            can_divide.append(number // div)

    can_divide = list(set(can_divide))
    (can_divide).sort()
    return can_divide

def existe_letra_a_na_palavra(palavra: str) -> bool:
    """
    Retorna True se existe a letra "a" minuscula na palavra
    """
    return bool(palavra.find('a') + 1)
```

Testes
```python
import pytest

def test_is_divisible():
    ## valida valores corretos
    assert is_divisible(1) == [1]
    assert is_divisible(10) == [1, 2, 5, 10]
    assert is_divisible(27) == [1, 3, 9, 27]
    assert is_divisible(89) == [1, 89]
    assert is_divisible(0) == []

    ## valida por erros esperados
    with pytest.raises(TypeError) as error:
        is_divisible(-10)
        is_divisible(-123)
        is_prime(int)

def test_is_prime():
    ## valida valores corretos
    assert is_prime(0) == True
    assert is_prime(1) == True
    assert is_prime(2) == True
    assert is_prime(20) == False
    assert is_prime(89) == True
    assert is_prime(99990) == False

    ## valida por erros esperados
    with pytest.raises(TypeError) as error:
        is_prime(-10)
        is_prime(str)

def test_existe_letra_a_na_palavra():
    ## valida valores corretos
    assert existe_letra_a_na_palavra("aaa") == True
    assert existe_letra_a_na_palavra("bbb") == False
    assert existe_letra_a_na_palavra("LETRA MAISCULA") == False

    ## valida por erros esperados
    with pytest.raises(AttributeError) as error:
        existe_letra_a_na_palavra(123)
        existe_letra_a_na_palavra(True)
        existe_letra_a_na_palavra(lambda x: True)
        existe_letra_a_na_palavra(None)
```

Vale a pena destacar que, além de verificar o resultado esperado do código desenvolvido, também é importante tentar entender e prever possíveis erros que podem surgir do seu código.