from openai import OpenAI
import json
import socket
import time

# OpenAI API 클라이언트 설정
client = OpenAI(api_key='')#API키 입력

def get_machine_script(command):
    system_message = read_system_prompt()
    response = client.chat.completions.create(
        model='gpt-4',
        messages=[
            system_message,
            {'role': 'user', 'content': command}
        ]
    )
    return response.choices[0].message['content']

def read_system_prompt():
    content = ''
    try:
        with open('file1.txt', 'r', encoding="UTF-8") as file:
            content += file.read() + '\n' * 2
        with open('file2.txt', 'r', encoding="UTF-8") as file:
            content += file.read()
    except FileNotFoundError as e:
        print(f"FileNotFoundError: {e}")
    return {'role': 'system', 'content': content}

def execute_machine_script(script):
    try:
        actions = json.loads(script)['Machina_Actions']
        for action_key, action in actions.items():
            if 'movements' in action and action['movements']:
                execute_movements(action['movements'])
    except json.JSONDecodeError as e:
        print(f"JSONDecodeError: {e}")
        print(f"Received script: {script}")
    except KeyError as e:
        print(f"KeyError: {e}")
        print(f"Received script: {script}")

motor_mapping = {
    'motor_neck_vertical': 19,
    'motor_neck_horizontal': 18,
}

def execute_movements(movements):
    print(movements)
    for movement_key, movement in movements.items():
        print(movement_key, movement)
        angle_v = movement.get('motor_neck_vertical', None)
        angle_h = movement.get('motor_neck_horizontal', None)
        speed = movement.get('speed', 'medium')
        print(angle_v, angle_h, speed)

        pin_v = motor_mapping.get('motor_neck_vertical', None)
        pin_h = motor_mapping.get('motor_neck_horizontal', None)
        print(pin_v, pin_h)

        if angle_v is not None:
            command = f'{pin_v},{angle_v},{speed}'
            if angle_v < 90:
                command = 'U'
            elif angle_v > 90:
                command = 'D'
            send_to_arduino(command)
            print(command)
            time.sleep(1)

        if angle_h is not None:
            command = f'{pin_h},{angle_h},{speed}'
            if angle_h < 90:
                command = 'L'
            elif angle_h > 90:
                command = 'R'
            print(command)
            send_to_arduino(command)
            time.sleep(1)

# 자바 UDP 서버로 보내주는 클라이언트 코드
a_host, a_port = '127.0.0.1', 7777
a_addr = (a_host, a_port)

a_client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

def send_to_arduino(command):
    print(command)
    data = command.encode('utf-8')
    a_client.sendto(data, a_addr)
    time.sleep(0.1)
