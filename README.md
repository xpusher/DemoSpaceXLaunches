## "Demo SpaceX Launches" (xpusherproj readme.md)

Проект "Demo SpaceX Launches" при первом входе скачивает из сети список запусков SpaceX и сохраняет в локальную БД, при последующих запусках приложеня отображаются данные из локальной БД

"Demo SpaceX Launches" реализован на основе паттерна Сlean Architecture
![Сlean Architecture](https://habrastorage.org/r/w1560/web/cbe/3fd/ad2/cbe3fdad2be24de3bd4dda6c66d56d76.png)

Проект может быть собран для Веб, Андроида, АйОС, Десктопа с одинаковым интерфесом и функционалом

Веб версия в интернете [Demo SpaceX Launches](https://xpusherproj.web.app/)

Для сборки Веб версии нужен CopyWebpackPlugin[https://webpack.js.org/plugins/copy-webpack-plugin/], выполните
npm install copy-webpack-plugin --save-dev


Спасибо [автору](https://habr.com/ru/users/Jeevuz/) за статью [ "Заблуждения Clean Architecture"](https://habr.com/ru/companies/mobileup/articles/335382/)



## Kotlin Multiplatform(default readme.md)

This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop, Server.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

**Note:** Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.