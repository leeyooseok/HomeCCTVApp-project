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
<br>

[![Android Studio](https://img.shields.io/badge/Android_Studio-346ac1?style=for-the-badge&logo=android-studio&logoColor=white)](https://github.com/leeyooseok/HomeCCTVApp-Android.git)

Android Studio는 안드로이드 애플리케이션 개발을 위한 통합 개발 환경(IDE)으로, 제가 만든 애플리케이션의 개발, 디버깅, 빌드, 그리고 실행을 위한 핵심 역할을 합니다.<br>
이 프로젝트에서는 CCTV영상 스트리밍,버튼으로 카메라제어,음성으로 카메라제어,조명제어가 가능하도록 구현하였습니다.<br>
애플리케이션은 UDP 통신을 통해 명령어를 네트워크로 전송하고, 아두이노와의 상호작용을 관리하는 역할을 담당합니다.<br>

<img src="https://img.shields.io/badge/-Arduino-00979D?style=for-the-badge&logo=Arduino&logoColor=white">
ARDUINO에서는 카메라의 움직임을 제어하는 모터와 조명의 밝기를 제어하는 LED핀을 안드로이드 스튜디오로부터 명령어로 받아서 지정된 명령을 수행하도록 구현하였습니다.<br>
아두이노에서 움직임을 구현하는 것은 크게 어렵지 않으나 기능을 하는 핀번호를 잘 확인하고 원하는 움직임을 구현하도록 체크해야합니다.<br>
<br>

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://github.com/leeyooseok/UDPServer.git)

IntelliJ에서는  안드로이드 스튜디오와 아두이노 간의 연결을 담당하는 서버로, UDP 프로토콜을 통해 데이터를 송수신합니다.<br> 
비연결형 통신 방식을 사용하여 빠르고 가벼운 데이터 전송을 가능하게 하며, 이를 통해 안드로이드에서 보내는 명령을 아두이노로 전달하고 그 결과를 확인하는 과정을 구현했습니다.<br>
서버의 포트 설정이 정확해야 하며, 이를 통해 명령이 문제없이 전송되도록 했습니다.
<br>
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
**Python**에서는 OpenAI를 사용하여 음성 인식 기반 명령을 처리할 수 있도록 구현했습니다. 이를 통해 사용자가 음성으로 명령을 내리면 Python이 이를 분석하고 적절한 명령을 UDP 서버로 전달합니다. 이 과정에서 API 키의 보안에 주의를 기울였으며, AI 모델의 동작에 필요한 파일을 체계적으로 관리하여 안전하고 유연한 시스템을 구현했습니다.


