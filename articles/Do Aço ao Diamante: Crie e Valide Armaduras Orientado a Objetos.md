# Do Aço ao Diamante: Crie e Valide Armaduras Orientado a Objetos

Criação de um Sistema Simples de RPG para Armaduras em Python, com Abordagem Orientada a Objetos e Validação da Lógica de Negócios


Aqui é o exemplo de código:
```python
class TipoArmadura:
    LEVE = "Leve"
    MEDIA = "Média"
    PESADA = "Pesada"

class Elemento:
    FOGO = "Fogo"
    GELO = "Gelo"
    ELETRICIDADE = "Eletricidade"

class ArmadurasExistentes:
    LEVES = ["Armadura de Couro", "Armadura de Pano"]
    MEDIAS = ["Armadura de Couro Revestida", "Armadura de Alumínio"]
    PESADAS = ["Armadura de Aço", "Armadura de Diamante"]

class Armadura:
    def __init__(self, nome: str, tipo: str, defesa: int, resistencia_elemental: dict):
        """
        Params:
            - nome: Nome da armadura
            - tipo: Tipo de armadura (ex: leve, pesada)
            - defesa: Valor de defesa fornecido pela armadura
            - resistencia_elemental: Resistência a elementos (ex: fogo)
        """
        self.nome = nome
        self.tipo = tipo
        self.defesa = defesa
        self.resistencia_elemental = resistencia_elemental

        self._validar_tipo()
        self._validar_elemento()
        self._validar_nome_e_tipo()

    def _validar_tipo(self):
        if self.tipo not in [TipoArmadura.LEVE, TipoArmadura.MEDIA, TipoArmadura.PESADA]:
            raise ValueError("Tipo de armadura inválido")
        
    def _validar_elemento(self):
        for elemento in self.resistencia_elemental:
            if elemento not in [Elemento.FOGO, Elemento.GELO, Elemento.ELETRICIDADE]:
                raise ValueError("Elemento de resistência inválido")

    def _validar_nome_e_tipo(self):
        mapa_de_verificacao = {
            TipoArmadura.LEVE: ArmadurasExistentes.LEVES,
            TipoArmadura.MEDIA: ArmadurasExistentes.MEDIAS,
            TipoArmadura.PESADA: ArmadurasExistentes.PESADAS,
        }
        if self.nome not in mapa_de_verificacao[self.tipo]:
            raise ValueError("Nome de armadura incompatível com o tipo: " + self.nome)

    def exibir_detalhes(self):
        print(f"Armadura: {self.nome}")
        print(f"Tipo: {self.tipo}")
        print(f"Defesa: {self.defesa}")
        print(f"Resistência Elemental: {self.resistencia_elemental}")


if __name__ == "__main__":
    # Exemplos de uso da classe
    armadura1 = Armadura("Armadura de Couro", "Leve", 50, {"Fogo": 10, "Gelo": 5})
    armadura1.exibir_detalhes()

    armadura2 = Armadura("Armadura de Aço", TipoArmadura.PESADA, 50, {Elemento.FOGO: 50, Elemento.GELO: 10})
    armadura2.exibir_detalhes()

    armadura3 = Armadura("Armadura de Diamante", TipoArmadura.PESADA, 100, {Elemento.FOGO: 50, Elemento.ELETRICIDADE: 10})
    armadura3.exibir_detalhes()

    ## descomente para testar o erro
    # armadura_inexistente = Armadura("Armadura de Ouro", TipoArmadura.PESADA, 50, {Elemento.FOGO: 50, Elemento.GELO: 10})
    # armadura_inexistente.exibir_detalhes()

```

O exemplo atual inclui dados de armaduras, tipos e elementos diretamente no código. No entanto, para um sistema mais robusto e escalável, recomenda-se a adoção de um banco de dados. Isso permite uma gestão eficiente dos dados, facilitando a expansão e manutenção contínua sem a necessidade de modificar o código-fonte. Dessa forma, sua aplicação estará pronta para evoluir e se adaptar sem complicações.