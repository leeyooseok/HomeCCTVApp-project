<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=350&&section=header&text=HomeCCTV%20AIoT%20project&fontSize=70">
</div>

<div align="center">
<img src="https://img.shields.io/badge/android%20studio-346ac1?style=for-the-badge&logo=android%20studio&logoColor=white">
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
<img src="https://img.shields.io/badge/-Arduino-00979D?style=for-the-badge&logo=Arduino&logoColor=white">
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
</div>
<br>

<div align="center">
  
[![Video Title](https://img.youtube.com/vi/6f63qniM9cY/0.jpg)](https://www.youtube.com/watch?v=6f63qniM9cY)

*이미지 클릭시 유튜브 동영상으로 이동*


## 프로젝트 개요 💡
이 프로젝트의 HomeCCTV프로그램을 구현한 프로젝트로 안드로이드 스튜디오를 통해 만든 어플리케이션을 통해 집안의 카메라를 제어하여 어디서나 실시간으로 모니터링을 통해 보안을 강화하고 집안의 조명을 제어하여 편리성을 제공하는것이 목표입니다.<br>

이 프로젝트는 아두이노에 할당된 명령어를 IP서버를 통해 Android Studio에 연결하여 원하는 명령을 전송할 수 있도록 구현한 프로그램입니다.<br>
현재까지 구현한 **기능**은<br>
- ip서버가 같은 네트워크에 연결된 카메라를 통해 어플리케이션에서 실시간 스트리밍이 가능합니다.
- 아두이노에 명령을 전송하여 상하좌우 버튼을 눌러 카메라의 움직임을 구현하였습니다.
- 간단한 음성명령을 통해 상하좌우 카메라의 움직임이 가능하도록 구현했습니다.
- 아두이노에 명령을 전송하여 조명제어기능을 추가하였습니다.
  
**추가 예정 기능**<br>
전등제어,집안 온도 확인,움직임 감지

--------------------------------------------

## 기술 스택 🛠️(뱃지를 클릭하면 해당 레퍼지토리로 이동합니다!)
<br>

[![Android Studio](https://img.shields.io/badge/Android_Studio-346ac1?style=for-the-badge&logo=android-studio&logoColor=white)](https://github.com/leeyooseok/HomeCCTVApp-Android.git)

**Android Studio**는 안드로이드 애플리케이션 개발을 위한 통합 개발 환경(IDE)으로, 제가 만든 애플리케이션의 개발, 디버깅, 빌드, 그리고 실행을 위한 핵심 역할을 합니다.<br>
이 프로젝트에서는 CCTV영상 스트리밍,버튼으로 카메라제어,음성으로 카메라제어,조명제어가 가능하도록 구현하였습니다.<br>
애플리케이션은 UDP 통신을 통해 명령어를 네트워크로 전송하고, 아두이노와의 상호작용을 관리하는 역할을 담당합니다.<br>

[![Arduino](https://img.shields.io/badge/Arduino-00979D?style=for-the-badge&logo=Arduino&logoColor=white)](https://github.com/leeyooseok/HomeCCTV-Arduino.git)

**Arduino**에서는 카메라의 움직임을 제어하는 모터와 조명의 밝기를 제어하는 LED핀을 안드로이드 스튜디오로부터 명령어로 받아서 지정된 명령을 수행하도록 구현하였습니다.<br>
아두이노에서 움직임을 구현하는 것은 크게 어렵지 않으나 기능을 하는 핀번호를 잘 확인하고 원하는 움직임을 구현하도록 체크해야합니다.<br>
<br>

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://github.com/leeyooseok/UDPServer.git)

**IntelliJ**에서는  안드로이드 스튜디오와 아두이노 간의 연결을 담당하는 서버로, UDP 프로토콜을 통해 데이터를 송수신합니다.<br> 
비연결형 통신 방식을 사용하여 빠르고 가벼운 데이터 전송을 가능하게 하며, 이를 통해 안드로이드에서 보내는 명령을 아두이노로 전달하고 그 결과를 확인하는 과정을 구현했습니다.<br>
서버의 포트 설정이 정확해야 하며, 이를 통해 명령이 문제없이 전송되도록 했습니다.
<br>

[![Python](https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white)](https://github.com/leeyooseok/HomeCCTV-openAI.git)

**Python**에서는 OpenAI를 사용하여 음성 인식 기반 명령을 처리할 수 있도록 구현했습니다. 이를 통해 사용자가 음성으로 명령을 내리면 Python이 이를 분석하고 적절한 명령을 UDP 서버로 전달합니다. 이 과정에서 API 키의 보안에 주의를 기울였으며, AI 모델의 동작에 필요한 파일을 체계적으로 관리하여 안전하고 유연한 시스템을 구현했습니다.

-----------------------------------------------------------------------

## 문제 해결 및 개선 사항🔑

- 처음에 블루투스를 통해 움직임을 제어하였는데 HomeCCTV의 목적상 거리가 멀어져도 제어가 가능해야 하는데 그 부분에서 결점이 있었습니다.
**해결방법**으로 UDP통신을 사용하여 원거리통신이 가능하게 하였고 이 방법이 더 목적성에 적합하다는걸 알게 되었습니다.

- 기능을 추가할수록 쓰레드가 쌓이면서 앱이 과부화하여 갑자기 종료되거나 멈추는 경우가 발생하였습니다.<br>
**해결방법**으로 ExecutorService를 사용 하여 쓰레드 수를 제한하였습니다. 이를 통해 메모리와 리소스를 효율적으로 관리할 수 있었습니다.
  
- 액티비티간의 전환에서 이전에 사용한 액티비티들의 스택이 쌓이면서 충돌이 일어났습니다.<br>
**해결방법**으로 ```intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);```을 사용 하여 이미 액티비티가 스택에 존재할 경우 그 위의 모든 액티비티를 제거하고 MainActivity로 돌아가도록 코딩헀습니다.

- 최초 음성으로 제어하는 기능을 추가하였을때 특정 단어(ex 위,아래,왼쪽)로만 움직임이 가능하게 구현하였다가 전달이 잘 안되는 경우가 있었습니다.<br>
**해결방법**으로 openAI를 사용하여 더 유연한 전달이 가능하게 하였습니다.

------------------------------------------

## 결과 및 성과📋

- 원격 카메라 제어를 통해 UDP통신에 대한 이해도와 흐름을 잘 이해할 수 있었습니다. 다음에 또 이러한 연결이 필요할 때 참고하고 도움이 될거 같습니다.
- 앱을 만드는 과정에서 일어났던 충돌들로 인해 안정성의 중요도를 잘 알았습니다. 앱을 새로 만들거나 기능을 추가할떄  충돌되거나 문제점이 생기는 위치를 잘 파악하고 해결해 나갈 수 있습니다.
- 보통 사용되고 있는 Homecctv어플에 비하면 기능적으로나 편리성 등 여러가지 아쉬운 부분이 많다고 생각합니다. 추가적으로 조금 더 편리함과 기능적인 부분을 보완하겠습니다.



