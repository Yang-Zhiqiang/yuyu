CREATE VIEW BM_KinyuuKikanHuhoyofuriInfo AS SELECT
     bankcd ,         /* 銀行コード */
     yofurikyouteikaisiymd ,         /* 預振協定開始年月日 */
     yofurikyouteikaijyoymd ,         /* 預振協定解除年月日 */
     itakusyakinyuucd ,         /* 委託者金融機関コード */
     itakusyasitencd ,         /* 委託者支店コード */
     itakusyayokinkbn ,         /* 委託者預金種目区分 */
     itakusyakouzano ,         /* 委託者口座番号 */
     tsrkeisanhoukbn ,         /* 手数料計算方法区分 */
     kinyuutesuuryou ,         /* 金融機関手数料 */
     itakusyacd ,         /* 委託者コード */
     tapekoukankbn1 ,         /* テープ交換区分１ */
     mdsisyacd ,         /* 窓口支社コード */
     zzkkyouteikaisiymd ,         /* 全税共協定開始年月日 */
     zzkkyouteikaijyoymd ,         /* 全税共協定解除年月日 */
     csskyouteikaisiymd ,         /* ＣＳＳ協定開始年月日 */
     csskyouteikaijyoymd ,         /* ＣＳＳ協定解除年月日 */
     huhoyofuriinfokousinymd ,         /* 普保預振情報更新年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KinyuuKikanHuhoyofuriInfo_Z;