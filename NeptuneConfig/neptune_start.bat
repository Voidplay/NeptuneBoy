@echo off
:: 设置项目的 JAR 包完整路径
set JAR_PATH=C:\Users\d11V\Desktop\temp\NeptuneBoy-1.0.0.jar

:: 检查 JAR 包是否存在
if not exist "%JAR_PATH%" (
    echo [ERROR] JAR 文件未找到：%JAR_PATH%
    pause
    exit /b
)

:: 切换到 JAR 包所在目录
cd /d C:\Users\d11V\Desktop\temp

:: 启动项目
echo 正在启动项目...
start "" java -jar %JAR_PATH%

:: 等待几秒以确保服务启动
timeout /t 5 >nul

:: 打开默认浏览器并指向 localhost:80
echo 打开浏览器访问 http://localhost:80
start http://localhost:80

:: 保持命令行窗口打开
echo 项目已启动，按任意键关闭此窗口...
pause
