CREATE TABLE IW_KhHaraikataHenkouWk_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     newhrkkeiro                                        VARCHAR     (2)                                                                 ,  /* （変更後）払込経路 */
     newhrkkaisuu                                       VARCHAR     (2)                                                                 ,  /* （変更後）払込回数 */
     newtikiktbrisyuruikbn                              VARCHAR     (2)                                                                 ,  /* （変更後）定期一括払種類区分 */
     henkouyoteiym                                      VARCHAR     (6)                                                                 ,  /* 変更（予定）年月 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzkykdoukbn                                        VARCHAR     (1)                                                                 ,  /* 口座名義契約者同一人区分 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     ykkigenyy                                          VARCHAR     (32)                                                                ,  /* 有効期限（ＹＹ） */
     ykkigenmm                                          VARCHAR     (32)                                                                ,  /* 有効期限（ＭＭ） */
     creditmeiginmkn                                    VARCHAR     (386)                                                               ,  /* クレジットカード名義人氏名（カナ） */
     authorikakyhkbn                                    VARCHAR     (1)                                                                 ,  /* オーソリ確認要否区分 */
     yykidouuktkkbn                                     VARCHAR     (1)                                                                 ,  /* 予約異動受付区分 */
     kyuukouzaannaikbn                                  VARCHAR     (1)                                                                 ,  /* 旧口座案内区分 */
     kanryotuutioutkbn                                  VARCHAR     (1)                                                                 ,  /* 完了通知出力区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     kyuukouzahurikaeymd                                VARCHAR     (8)                                                                 ,  /* 旧口座振替日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     creditkessaiyouno                                  VARCHAR     (26)                                                                   /* クレジットカード決済用番号 */
)
;

ALTER TABLE IW_KhHaraikataHenkouWk_Z ADD CONSTRAINT PK_KhHaraikataHenkouWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
