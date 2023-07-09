CREATE VIEW HM_SkHokenSyuruiNo AS SELECT
     hknsyuruino ,         /* 保険種類番号 */
     hknsyuruinosd ,         /* 保険種類番号世代 */
     hyoujifromymd ,         /* 表示日自 */
     hyoujitoymd ,         /* 表示日至 */
     hknsyuruinm ,         /* 保険種類名 */
     hknsyuruinmsyanaidisp ,         /* 保険種類名（社内表示用） */
     hknsyuruiworklist ,         /* 保険種類名（ワークリスト用） */
     daihyouhknsyuruino ,         /* 代表保険種類番号 */
     inputctrlsyouhncd ,         /* 入力制御用商品コード */
     inputctrlsyouhnsdno ,         /* 入力制御用商品世代番号 */
     dai1hknkknselect ,         /* 第１保険期間選択肢 */
     targettkmkhtselect ,         /* ターゲット特約目標値選択肢 */
     syohnsortno ,         /* 商品ソート番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkHokenSyuruiNo_Z;