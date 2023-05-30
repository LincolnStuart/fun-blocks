![license](https://img.shields.io/badge/license-mit-red?style=for-the-badge)
![api](https://img.shields.io/badge/api-26+-yellow?style=for-the-badge)

<div align="center">
<br />
<img width="120" src="https://github.com/LincolnStuart/fun-blocks/assets/8579195/bab90816-b2be-494d-9634-18b388aef7ad"/>
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
FunBlocksTheme { 
    Surface { 
        NotificationCounter(number = 5) { 
            Avatar(
                mode = AvatarMode.Initials(fullName = "Lincoln Stuart")
            ) 
        } 
    }
}
```

</td>
<td>
<img width="50" src="https://github.com/LincolnStuart/fun-blocks/assets/8579195/2936f7f6-01a2-4b04-a2da-2949a5dd167d" />
</td>
</tr>
</table>

Based on [Jetpack Compose](https://developer.android.com/jetpack/compose).

It's recommended for `POCs`, `studies` and even `production`!

It works with [Material](https://developer.android.com/jetpack/androidx/releases/compose-material).

## 35+ Components
- `Calendar`, `Month Picker`, `Time Picker`.
- `Linear Chart`, `Bar Chart`, `Pie/Donut Chart`.
- `Chips`, `Badges`, `Alerts`
- And more...

## Next Steps
- Downgrade API Level.
- Publish the sample on [Google Play Store](https://play.google.com/).
- [KMM](https://kotlinlang.org/docs/multiplatform-mobile-getting-started.html) Support.