CREATE VIEW HM_SkHokenSyuruiNoAisyou AS SELECT
     hknsyuruino ,         /* 保険種類番号 */
     hknsyuruinosdfrom ,         /* 保険種類番号世代自 */
     hknsyuruinosdto ,         /* 保険種類番号世代至 */
     hknsyuruinobetukey1 ,         /* 保険種類番号別キー１ */
     aisyoumeichannelkbn ,         /* 愛称名チャネル区分 */
     aisyoumeikbn ,         /* 愛称名区分 */
     aisyoumei ,         /* 愛称名 */
     husyoudakumanualinfo ,         /* 不承諾手続きマニュアル情報 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkHokenSyuruiNoAisyou_Z;