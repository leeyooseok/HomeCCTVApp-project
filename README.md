<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=350&&section=header&text=HomeCCTV%20AIoT%20project&fontSize=70">
</div>

<div align="center">
<img src="https://img.shields.io/badge/android%20studio-346ac1?style=for-the-badge&logo=android%20studio&logoColor=white">
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
<img src="https://img.shields.io/badge/-Arduino-00979D?style=for-the-badge&logo=Arduino&logoColor=white">
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
</div>

## 프로젝트 개요 💡
이 프로젝트의 HomeCCTV프로그램을 구현한 프로젝트로 안드로이드 스튜디오를 통해 만든 어플리케이션을 통해 집안의 카메라를 제어하여 어디서나 실시간으로 모니터링을 통해 보안을 강화하고 집안의 전등을 제어하여 편리성을 제공하는것이 목표입니다.<br>

이 프로젝트는 아두이노에 할당된 명령어를 IP서버를 통해 Android Studio에 연결하여 원하는 명령을 전송할 수 있도록 구현한 프로그램입니다.<br>
현재까지 구현한 기능은<br>
- ip서버가 같은 네트워크에 연결된 카메라를 통해 어플리케이션에서 실시간 스트리밍이 가능합니다.
- 아두이노에 명령을 전송하여 상하좌우 버튼을 눌러 카메라의 움직임을 구현하였습니다.
- 간단한 음성명령을 통해 상하좌우 카메라의 움직임이 가능하도록 구현했습니다.
- 아두이노에 명령을 전송하여 전등제어기능을 추가하였습니다.

--------------------------------------------

## 기술 스택 🛠️
<img src="https://img.shields.io/badge/-Arduino-00979D?style=for-the-badge&logo=Arduino&logoColor=white">
ARDUINO에서는 카메라의 움직임을 제어하는 모터와 조명의 밝기를 제어하는 LED핀을 안드로이드 스튜디오로부터 명령어로 받아서 지정된 명령을 수행하도록 구현하였습니다.<br>
아두이노에서 움직임을 구현하는 것은 크게 어렵지 않으나 기능을 하는 핀번호를 잘 확인하고 원하는 움직임을 구현하도록 체크해야합니다.
<br>
<br>

<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
https://github.com/leeyooseok/UDPServer.git<br>
IntelliJ에서는 아두이노와 안드로이드 스튜디오를 연결하는 UDP서버를 구축하는 역할을 구현하였습니다.<br>
UDP서버는 비연결형 프로토콜로 네트워크 상에서 데이터그램을 송수신하는데 사용됩니다.<br>
아두이노에서 사용되는 포트와 인텔리제이의 포트를 틀리지않게 입력하여 송수신의 연결에 문제가 없도록 확인하며, 안드로이드 스튜디오에서 보내는 커맨드가 정확하게 입력되는지 확인이 가능하고 아두이노에 명령어를 전달하는 것에 목적을 두었습니다.<br>
<br>
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
python에서는 음성으로 보내는 명령을 openAI를 통해 유연하게 적용하여 움직임이 가능하도록 구현하였습니다.
API_KEY의 보안문제를 주의해야하며 같이 첨부해둔 파일의 내용이 AI모델의 방향성을 제시할 수 있기에 파일의 내용을 잘 정리해두는것이 중요합니다.


