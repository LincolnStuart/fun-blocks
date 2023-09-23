![license](https://img.shields.io/badge/license-mit-red?style=for-the-badge)
![api](https://img.shields.io/badge/api-24+-yellow?style=for-the-badge)
![kmp](https://img.shields.io/badge/kmp-%E2%9D%A4-purple?style=for-the-badge)

<div align="center">
<br />
<img width="120" src="https://github.com/LincolnStuart/fun-blocks/assets/8579195/389e592c-d878-4748-8298-94103566cee9"/>
<h2>Fun Blocks: Let's stack some components and make your app!</h2>
</div>

Have you ever imagined build apps like playing `LEGO` or `Playmobil`?

`Fun Blocks` is a plug & play `component framework` and `design system` which smooth your dev experience.

<table>
<tr>
<th> Code </th>
<th> Result </th>
</tr>
<tr>
<td>

```kotlin
ScreenPlan(
    mainContent = {
        CounterNotification(number = 5) {
            Avatar(
                mode = AvatarMode.Initials(fullName = "Lincoln Stuart")
            ) {}
        }
    }
)
```

</td>
<td>
<img width="60" src="https://github.com/LincolnStuart/fun-blocks/assets/8579195/d36243ff-e5cf-41ac-a23f-8d218bc90955" />
</td>
</tr>
</table>

Based on [Jetpack Compose](https://developer.android.com/jetpack/compose).

It's recommended for `POCs`, `studies` and even `production`!

## 35+ Components
- `Text`, `Input`, `Pin`.
- `Chips`, `Badges`, `Alerts`.
- `Slider`, `Incrementer`, `Stepper`, `Progress Bar`.
- `Linear Chart`, `Bar Chart`, `Pie/Donut Chart`.
- And more...


## Next Steps
- Publish lib on Maven.
- Publish the playground on [Google Play Store](https://play.google.com/).