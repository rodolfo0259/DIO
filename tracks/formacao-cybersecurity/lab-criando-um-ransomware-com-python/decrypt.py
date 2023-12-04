import os
import pyaes

file_name = "teste.txt.ransomwaretroll"
with open(file_name, 'rb') as f:
    file_data = f.read()

key = b"testeransomwares" ## keys should not be in the same file, consider compiling the python code to make it harder
aes = pyaes.AESModeOfOperationCTR(key)
decrypt_data = aes.decrypt(file_data)

with open("teste.txt", "wb") as f:
    f.write(decrypt_data)

## only remove encrypted file if successful decrypted
os.remove(file_name)