# InterestingTool




https://github.com/user-attachments/assets/f7567ace-4171-4d0a-bbcb-405ee5b5fc4a




## プラグイン説明
面白便利ツールを追加する

## プラグインダウンロード
[ダウンロードリンク](https://github.com/ringoame196-s-mcPlugin/InterestingTool/releases/latest)

## コマンド
| コマンド名   |     説明      | 権限 |
| --- | ----------- | ------- |
|/intertool|ツールを出せるGUIを開く | op |

## ツール一覧
| ツール名                 | 説明                                | 右クリック               | 左クリック                | ブロック破壊                 | 攻撃                    |
|----------------------|--------------------------------|-------------------|------------------|------------------|------------------|
| **雪玉シャベル**         | 雪玉を発射できる                      | 雪玉を発射            |                  |                  |                  |
| **ファイヤーボール斧**     | ファイヤーボールを発射できる                |                   | ファイヤーボール発射    |                  |                  |
| **雷斧**             | ターゲットに雷を落とす                  |                   |                  |                  | 雷を落とす            |
| **パチンコピッケル**     | 鉱石のドロップ数をランダムに変更（0～8個）    |                   |                  | 0～8個のドロップに変化  |                  |
| **かまどピッケル**       | ブロックを焼いた状態でドロップさせる         |                   |                  | 焼いた状態でドロップ   |                  |
| **自動切り替えツール**    | 適切なツールへ自動で切り替え（一部アイテムのみ） |                   |                  | 適切なツールへ自動切替 |                  |
| **Putアイテムツール**    | 破壊したブロックのアイテムを直接インベントリへ |                   |                  | 取ったアイテムをインベントリへ |                  |
| **Putエンダーチェストツール** | 破壊したブロックのアイテムをエンダーチェストへ | エンダーチェストを開く    |                  | 取ったアイテムをエンダーチェストへ |                  |
| **Putチェスト斧**      | 破壊したブロックのアイテムを設定したチェストへ  | 設定したチェストを開く  | スニーク＋クリックでチェスト設定 |                  | 取ったアイテムを設定したチェストへ |


## 開発環境
- Minecraft Version : 1.20.1
- Kotlin Version : 1.8.0

## プロジェクト情報
- プロジェクトパス : ringoame196-s-mcPlugin/InterestingTool.git
- 開発者名 : ringoame196-s-mcPlugin
- 開発開始日 : 2025-03-17

## 開発メモ
| クラス/インターフェース | 継承/実装 | 説明 |
|----------------|------|------------------------------|
| InterestingTool | 継承可能 | ツールの基底クラス |
| Attack         | インターフェース | 攻撃時に何かを起こす |
| BlockDamage    | インターフェース | ブロックにダメージを与えたときに何かを起こす |
| BreakBlock     | インターフェース | ブロック破壊時に何かを起こす |
| LeftClick      | インターフェース | 左クリック時に何かを起こす |
| RightClick     | インターフェース | 右クリック時に何かを起こす |
