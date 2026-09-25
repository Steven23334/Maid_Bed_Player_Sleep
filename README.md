# Touhou Little Maid: Maid Bed Player Sleep

[![Available on GitHub](https://wsrv.nl/?url=https%3A%2F%2Fcdn.jsdelivr.net%2Fnpm%2F%40intergrav%2Fdevins-badges%403%2Fassets%2Fcozy%2Favailable%2Fgithub_vector.svg&n=-1)](https://github.com/Steven23334/Maid_Bed_Player_Sleep)
[![Available for Touhou Little Maid](https://cdn.modrinth.com/data/cached_images/ea5dc160571134bd0ea89ac52075b542fb331e46_0.webp)](https://modrinth.com/project/R0bDWFAW)

This is an addon for the **Touhou Little Maid** mod. It makes the maid bed usable by players, so you can sleep in it just like a vanilla bed.

## 📦 New Content

- **Player Sleep on Maid Bed**  
  The maid bed is now recognized by the vanilla sleeping API as a valid bed for players. Right-click the maid bed and the player will lie down and sleep as usual — skipping the night, setting the respawn point, and all other vanilla bed behaviors work normally.

- **Original Maid Interaction Preserved**  
  The maid's own interactions with the bed are not affected. The mod only adds player support on top of the existing behavior.

## 🎯 Purpose

- Lets players actually use the maid bed they crafted, instead of it being a maid-only decoration.
- Keeps vanilla sleep mechanics intact — no custom sleep logic, no extra GUI.
- Minimal and targeted: one Mixin plus one interaction hook.

## 🔧 Installation

1. Make sure the **Touhou Little Maid** mod is installed.
2. Place the `.jar` file of this mod into the `.minecraft/mods` folder.
3. Launch the game.

## ⚙️ Configuration

No configuration. This mod is designed to be plug-and-play.

## ⚠️ Requirements

- **Minecraft Versions**: 1.21.1
- **Mod Loader**: NeoForge
- **Required Mod**: [Touhou Little Maid](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid)

## ⚠️ Compatibility Notice: Touhou Little Maid: Love & Loathe

This mod is **not guaranteed** to be fully compatible with **Touhou Little Maid: Love & Loathe**.

This mod Mixin-patches `BlockMaidBed#isBed` so the vanilla sleeping API treats the maid bed as a valid bed for players, and hooks the right-click interaction to start sleeping. It has no config screen and no toggle — it is always active once installed.

Love & Loathe is a separate addon that provides its own maid behavior and interaction features. If it also touches the maid bed or player sleeping, enabling both at the same time may cause:

- Overlapping or conflicting sleep behavior on the maid bed.
- Unexpected results when right-clicking the maid bed.
- One mod's behavior appearing to override the other.

Because this mod has no toggle, the only way to isolate a conflict is to **disable one of the two mods entirely**. You assume the risk of mixing them.

## 📜 License

- Code: [MIT License](https://mit-license.org/)

## 🙏 Authors

- Programmer: Steven23334
- Inspiration: JumDa5he (Touhou Little Maid: Love & Loathe)

---

# 车万女仆：女仆床玩家睡眠

[![可在 GitHub 上获取](https://wsrv.nl/?url=https%3A%2F%2Fcdn.jsdelivr.net%2Fnpm%2F%40intergrav%2Fdevins-badges%403%2Fassets%2Fcozy%2Favailable%2Fgithub_vector.svg&n=-1)](https://github.com/Steven23334/Maid_Bed_Player_Sleep)
[![适用于车万女仆](https://cdn.modrinth.com/data/cached_images/ea5dc160571134bd0ea89ac52075b542fb331e46_0.webp)](https://modrinth.com/project/R0bDWFAW)

这是一个为 **车万女仆 (Touhou Little Maid)** 模组开发的拓展，让女仆床可以被玩家使用，像原版床一样睡觉。

## 📦 新增内容

- **玩家可在女仆床上睡觉**  
  女仆床现在会被原版睡眠 API 识别为玩家可用的床。右键女仆床，玩家即可躺下入睡——跳过夜晚、设置重生点等所有原版床行为均正常工作。

- **保留女仆原有交互**  
  女仆对床的原有交互不受影响。本模组只是在原有行为之上增加了对玩家的支持。

## 🎯 模组用途

- 让玩家真正用上自己合成的女仆床，而不是只能当作女仆专用装饰。
- 保持原版睡眠机制完整——没有自定义睡眠逻辑，没有额外界面。
- 改动最小且精准：一个 Mixin 加一个交互钩子。

## 🔧 安装方法

1. 确保已安装 **车万女仆 (Touhou Little Maid)** 模组。
2. 将本模组的 `.jar` 文件放入 `.minecraft/mods` 文件夹。
3. 启动游戏即可。

## ⚙️ 配置

无需配置。本模组设计为即插即用。

## ⚠️ 前置要求

- **Minecraft 版本**：1.21.1
- **模组加载器**：NeoForge
- **必需模组**：[车万女仆 (Touhou Little Maid)](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid)

## ⚠️ 兼容性提示：Touhou Little Maid: Love & Loathe

本模组**不保证**与 **Touhou Little Maid: Love & Loathe** 的完全兼容性。

本模组通过 Mixin 修改 `BlockMaidBed#isBed`，让原版睡眠 API 将女仆床识别为玩家可用的床，并挂钩右键交互以进入睡眠。它没有配置界面，也没有开关——安装后即始终生效。

Love & Loathe 是一个独立拓展，提供自己的女仆行为与交互功能。若它同样涉及女仆床或玩家睡眠，两者同时启用可能导致：

- 女仆床上的睡眠行为重叠或冲突。
- 右键女仆床时出现预期之外的结果。
- 一方的行为看起来覆盖了另一方。

由于本模组没有开关，排查冲突的唯一方式是**完整禁用两个模组中的一个**。请自行承担混用带来的风险。

## 📜 许可证

- 代码：[MIT License](https://mit-license.org/)

## 🙏 作者

- 程序：Steven23334
- 灵感来源：JumDa5he（Touhou Little Maid: Love & Loathe）