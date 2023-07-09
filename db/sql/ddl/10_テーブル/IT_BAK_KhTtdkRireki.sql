CREATE TABLE IT_BAK_KhTtdkRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー                                        */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー                                        */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード                                       */
     shrsyousaiumu                                      VARCHAR     (1)                                                                 ,  /* 支払詳細有無区分                                      */
     syorikbn                                           VARCHAR     (2)                                                                 ,  /* 処理区分                                          */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分                                      */
     henkourrkumu                                       VARCHAR     (1)                                                                 ,  /* 変更履歴有無                                        */
     smbckanriid                                        VARCHAR     (11)                                                                ,  /* ＳＭＢＣ受付管理ＩＤ                                    */
     nayosekihontblskbtkey                              VARCHAR     (20)                                                                ,  /* 名寄せ基本テーブル識別キー                                 */
     kouteikanriid                                      VARCHAR     (20)                                                                ,  /* 工程管理ＩＤ                                        */
     youkyuuno                                          VARCHAR     (18)                                                                ,  /* 要求通番                                          */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_BAK_KhTtdkRireki ADD CONSTRAINT PK_BAK_KhTtdkRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー                                           */
     syono                                                    , /* 証券番号                                           */
     trkssikibetukey                                          , /* 取消識別キー                                         */
     henkousikibetukey                                          /* 変更識別キー                                         */
) ;
