import random
import keyboard
import serial
import requests
import time
import pyautogui
import subprocess
from getmac import get_mac_address


arduino = serial.Serial("COM3", 9600, timeout=0.2, parity = serial.PARITY_NONE, rtscts=1)
#clientId = random.randint(1, 10000000)
clientId = get_mac_address()

print("NEC - 1\nSONY - 2\n")
print("Enter Device Library Code:\n")
i = input()
match i:
    case "1":
        deviceId = "NEC"
    case "2":
        deviceId = "SONY"
    case default:
        deviceId = "none"
def execute_command(cmd):

    # Wycisz
    if cmd == "volume_up":
        keyboard.send("volume up")
    elif cmd == "volume_down":
        keyboard.send("volume down")
    elif cmd == "mute":
        keyboard.send("volume mute")
    elif cmd == "space":
        pyautogui.press("space")
    elif cmd == "tab":
        pyautogui.press("tab")
    elif cmd == "AltF4":
        pyautogui.hotkey('alt','f4')
    if cmd == "up":
        pyautogui.press("up")
    elif cmd == "down":
        pyautogui.press("down")
    elif cmd == "right":
        pyautogui.press("right")
    elif cmd == "left":
        pyautogui.press("left")
    elif cmd == "shift":
        pyautogui.press("shift")
    elif cmd == "z":
        pyautogui.press("z")
    elif cmd == "x":
        pyautogui.press("x")
    elif cmd == "p":
        pyautogui.press("p")
    elif cmd == "o":
        pyautogui.press("o")
    elif cmd == "i":
        pyautogui.press("i")
    elif cmd == "enter":
        pyautogui.press("enter")
    elif cmd == "backspace":
        pyautogui.press("backspace")
    elif cmd == "esc":
        pyautogui.press("esc")
    elif cmd == "CtrlF5":
        pyautogui.hotkey('ctrl','f5')
    else:
        pass
        #print("Brak akcji.")

while True:

    # 1. Czekamy na IR
    if arduino.in_waiting:
        ir_code = arduino.readline().decode('utf-8').strip()
        print(f" {ir_code}")
        # 2. Wysyłamy kod do serwera
        requests.post("http://192.168.67.60:8080/api/ir/submit", json={"code": ir_code, "clientId": clientId, "deviceId": deviceId})
        # 3. Polling: co 1s sprawdzamy, czy jest komenda
        while True:
            res = requests.get("http://192.168.67.60:8080/api/ir/get-command", params={"clientId": clientId, "deviceId": deviceId})
            cmd = res.json().get("command")
            if cmd:
                #print(f"Komenda do wykonania: {cmd}")
                execute_command(cmd)
                break