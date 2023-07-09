CREATE TABLE IT_BAK_DattaiUktk (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     dattaikeiro                                        VARCHAR     (2)                                                                 ,  /* 脱退経路 */
     dattairiyuukbn                                     VARCHAR     (2)                                                                 ,  /* 脱退理由区分 */
     dattaiym                                           VARCHAR     (6)                                                                 ,  /* 脱退年月 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     hurikaeymd                                         VARCHAR     (8)                                                                 ,  /* 振替日 */
     creditdatakbn                                      VARCHAR     (1)                                                                 ,  /* クレジットデータ区分 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditbrerrorcd                                    VARCHAR     (3)                                                                 ,  /* クレジット払エラーコード */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     comment124keta                                     VARCHAR     (124)                                                               ,  /* コメント（１２４桁） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     creditkessaiyouno                                  VARCHAR     (26)                                                                   /* クレジットカード決済用番号 */
)
;

ALTER TABLE IT_BAK_DattaiUktk ADD CONSTRAINT PK_BAK_DattaiUktk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
