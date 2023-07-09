CREATE TABLE HT_SmbcStyKanriSsRireki (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     syrctrltblkostime                                  VARCHAR     (17)                                                                ,  /* 処理コントロールTBL更新時間 */
     renkanryoflg                                       NUMBER      (1)                                                                 ,  /* 連動完了フラグ */
     smbcdatakbn                                        VARCHAR     (1)                                                                 ,  /* ＳＭＢＣ＿データ区分 */
     smbcdatasakuseiymd                                 VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿データ作成日 */
     smbchknkaisyacd                                    VARCHAR     (2)                                                                 ,  /* ＳＭＢＣ＿保険会社コード */
     smbcuktkkanriid                                    VARCHAR     (11)                                                                ,  /* ＳＭＢＣ＿受付管理ID */
     smbcseihouktkzmymd                                 VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保受付済DATE */
     smbcseihohbymd                                     VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保不備DATE */
     smbcbankhnkykflg                                   VARCHAR     (1)                                                                 ,  /* ＳＭＢＣ＿銀行返却フラグ */
     smbcseihohbksyymd                                  VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保不備解消DATE */
     smbcseihohjyttykymd                                VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保報状到着DATE */
     smbcseihonyknzmymd                                 VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保入金済DATE */
     smbcseihosnszmymd                                  VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保審査済DATE */
     smbcseihosyknhkkzmymd                              VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保証券発行済DATE */
     smbcseihosyumoku                                   VARCHAR     (2)                                                                 ,  /* ＳＭＢＣ＿生保種目 */
     smbcseihosyurui                                    VARCHAR     (2)                                                                 ,  /* ＳＭＢＣ＿生保種類 */
     smbcsyono                                          VARCHAR     (12)                                                                ,  /* ＳＭＢＣ＿証券番号 */
     smbcsyonoedaban                                    VARCHAR     (5)                                                                 ,  /* ＳＭＢＣ＿証券番号枝番 */
     smbcjktkflg                                        VARCHAR     (1)                                                                 ,  /* ＳＭＢＣ＿条件付フラグ */
     smbcseihotrksymd                                   VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保取消DATE */
     smbcseihohktymd                                    VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿生保否決DATE */
     smbckykseiymd                                      VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿契約者生年月日 */
     smbckyknmkn                                        VARCHAR     (80)                                                                ,  /* ＳＭＢＣ＿契約者名（カナ） */
     smbcmosuktymd                                      VARCHAR     (8)                                                                 ,  /* ＳＭＢＣ＿申込書受付DATE */
     smbcmossyoriflg                                    VARCHAR     (1)                                                                 ,  /* ＳＭＢＣ＿申込処理フラグ */
     smbckosyaareastyknr                                VARCHAR     (26)                                                                ,  /* ＳＭＢＣ＿個社領域（進捗管理） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_SmbcStyKanriSsRireki ADD CONSTRAINT PK_SmbcStyKanriSsRireki PRIMARY KEY (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_SmbcStyKanriSsRireki ON HT_SmbcStyKanriSsRireki (
     mosno                                                      /* 申込番号 */
) ;
