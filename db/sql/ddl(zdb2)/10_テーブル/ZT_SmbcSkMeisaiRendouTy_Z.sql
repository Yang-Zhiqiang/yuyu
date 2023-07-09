CREATE TABLE ZT_SmbcSkMeisaiRendouTy_Z (
     ztysmbcdatakbn                                     VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）ＳＭＢＣ＿データ区分 */
     ztysmbcdatasakuseiymd                              VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）ＳＭＢＣ＿データ作成日 */
     ztysmbchknkaisyacd                                 VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）ＳＭＢＣ＿保険会社コード */
     ztysmbcuktkkanriid                                 VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）ＳＭＢＣ＿受付管理ＩＤ */
     ztysmbcseihouktkzmymd                              VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保受付済ＤＡＴＥ */
     ztysmbcseihohbymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保不備ＤＡＴＥ */
     ztysmbcbankhnkykflg                                VARCHAR     (1)                                                                 ,  /* （中継用）ＳＭＢＣ＿銀行返却フラグ */
     ztysmbcseihohbksyymd                               VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ */
     ztysmbcseihohjyttykymd                             VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ */
     ztysmbcseihonyknzmymd                              VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保入金済ＤＡＴＥ */
     ztysmbcseihosnszmymd                               VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保審査済ＤＡＴＥ */
     ztysmbcseihosyknhkkzmymd                           VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ */
     ztysmbcseihosyumoku                                VARCHAR     (2)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保種目 */
     ztysmbcseihosyurui                                 VARCHAR     (2)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保種類 */
     ztysmbcsyono                                       VARCHAR     (12)                                                                ,  /* （中継用）ＳＭＢＣ＿証券番号 */
     ztysmbcsyonoedaban                                 VARCHAR     (5)                                                                 ,  /* （中継用）ＳＭＢＣ＿証券番号枝番 */
     ztysmbcjktkflg                                     VARCHAR     (1)                                                                 ,  /* （中継用）ＳＭＢＣ＿条件付フラグ */
     ztysmbcseihotrksymd                                VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保取消ＤＡＴＥ */
     ztysmbcseihohktymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿生保否決ＤＡＴＥ */
     ztysmbckykseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿契約者生年月日 */
     ztysmbckyknmkn                                     VARCHAR     (162)                                                               ,  /* （中継用）ＳＭＢＣ＿契約者名（カナ） */
     ztysmbcmosuktymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）ＳＭＢＣ＿申込書受付ＤＡＴＥ */
     ztysmbcmossyoriflg                                 VARCHAR     (1)                                                                 ,  /* （中継用）ＳＭＢＣ＿申込処理フラグ */
     ztysmbckosyaareastyknr                             VARCHAR     (26)                                                                ,  /* （中継用）ＳＭＢＣ＿個社領域（進捗管理） */
     ztyyobiv60                                         VARCHAR     (60)                                                                ,  /* （中継用）予備項目Ｖ６０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SmbcSkMeisaiRendouTy_Z ADD CONSTRAINT PK_SmbcSkMeisaiRendouTy PRIMARY KEY (
     ztysmbcdatakbn                                           , /* （中継用）ＳＭＢＣ＿データ区分 */
     ztysmbcdatasakuseiymd                                    , /* （中継用）ＳＭＢＣ＿データ作成日 */
     ztysmbchknkaisyacd                                       , /* （中継用）ＳＭＢＣ＿保険会社コード */
     ztysmbcuktkkanriid                                         /* （中継用）ＳＭＢＣ＿受付管理ＩＤ */
) ;
