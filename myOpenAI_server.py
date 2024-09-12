import socket
from machine_script import get_machine_script, execute_machine_script

host = '0.0.0.0'  # 임의의 네트워크 주소
port = 9999

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind((host, port))

print(f"Server listening on {host}:{port}")

try:
    while True:
        try:
            data, addr = server.recvfrom(1024)
            data = data.decode('utf-8')

            print(f'Client: {data}')

            command = data
            script = get_machine_script(command)
            execute_machine_script(script)
        except Exception as e:
            print(f"Error handling data: {e}")
finally:
    server.close()
    print("Server closed.")
