CREATE TABLE ZT_SmbcSkMeisaiRendouRn_Z (
     zrnsmbcdatakbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿データ区分 */
     zrnsmbcdatasakuseiymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿データ作成日 */
     zrnsmbchknkaisyacd                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿保険会社コード */
     zrnsmbcuktkkanriid                                 CHAR        (11)                                                      NOT NULL  ,  /* （連携用）ＳＭＢＣ＿受付管理ＩＤ */
     zrnsmbcseihouktkzmymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保受付済ＤＡＴＥ */
     zrnsmbcseihohbymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保不備ＤＡＴＥ */
     zrnsmbcbankhnkykflg                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿銀行返却フラグ */
     zrnsmbcseihohbksyymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ */
     zrnsmbcseihohjyttykymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ */
     zrnsmbcseihonyknzmymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保入金済ＤＡＴＥ */
     zrnsmbcseihosnszmymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保審査済ＤＡＴＥ */
     zrnsmbcseihosyknhkkzmymd                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ */
     zrnsmbcseihosyumoku                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保種目 */
     zrnsmbcseihosyurui                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保種類 */
     zrnsmbcsyono                                       CHAR        (12)                                                      NOT NULL  ,  /* （連携用）ＳＭＢＣ＿証券番号 */
     zrnsmbcsyonoedaban                                 CHAR        (5)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿証券番号枝番 */
     zrnsmbcjktkflg                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿条件付フラグ */
     zrnsmbcseihotrksymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保取消ＤＡＴＥ */
     zrnsmbcseihohktymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿生保否決ＤＡＴＥ */
     zrnsmbckykseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿契約者生年月日 */
     zrnsmbckyknmkn                                     CHAR        (80)                                                      NOT NULL  ,  /* （連携用）ＳＭＢＣ＿契約者名（カナ） */
     zrnsmbcmosuktymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿申込書受付ＤＡＴＥ */
     zrnsmbcmossyoriflg                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＳＭＢＣ＿申込処理フラグ */
     zrnsmbckosyaareastyknr                             CHAR        (26)                                                      NOT NULL  ,  /* （連携用）ＳＭＢＣ＿個社領域（進捗管理） */
     zrnyobiv60                                         CHAR        (60)                                                      NOT NULL    /* （連携用）予備項目Ｖ６０ */
)
;

ALTER TABLE ZT_SmbcSkMeisaiRendouRn_Z ADD CONSTRAINT PK_SmbcSkMeisaiRendouRn PRIMARY KEY (
     zrnsmbcdatakbn                                           , /* （連携用）ＳＭＢＣ＿データ区分 */
     zrnsmbcdatasakuseiymd                                    , /* （連携用）ＳＭＢＣ＿データ作成日 */
     zrnsmbchknkaisyacd                                       , /* （連携用）ＳＭＢＣ＿保険会社コード */
     zrnsmbcuktkkanriid                                         /* （連携用）ＳＭＢＣ＿受付管理ＩＤ */
) ;
