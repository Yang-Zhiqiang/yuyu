CREATE TABLE BT_SystemRenkei_Z (
     interfaceid                                        VARCHAR     (4)                                                       NOT NULL  ,  /* インターフェースＩＤ */
     syorihousiki                                       VARCHAR     (1)                                                                 ,  /* 処理方式 */
     henkanhoukou                                       VARCHAR     (1)                                                                 ,  /* 変換方向 */
     henkanmaelayoutid                                  VARCHAR     (50)                                                                ,  /* 変換前レイアウトＩＤ */
     henkanmaelayoutname                                VARCHAR     (402)                                                               ,  /* 変換前レイアウト名 */
     henkangolayoutid                                   VARCHAR     (50)                                                                ,  /* 変換後レイアウトＩＤ */
     henkangolayoutname                                 VARCHAR     (402)                                                               ,  /* 変換後レイアウト名 */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     renkeifiledirectory                                VARCHAR     (80)                                                                ,  /* 連携ファイル格納ディレクトリ */
     renkeifilenm                                       VARCHAR     (100)                                                               ,  /* 連携ファイル名 */
     renkeifiletype                                     VARCHAR     (1)                                                                 ,  /* 連携ファイル種別 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_SystemRenkei_Z ADD CONSTRAINT PK_SystemRenkei PRIMARY KEY (
     interfaceid                                                /* インターフェースＩＤ */
) ;
