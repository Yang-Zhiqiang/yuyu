CREATE TABLE IT_YuukouKakKekkaKikyk_Z (
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     creditcardno                                       VARCHAR     (16)                                                                ,  /* クレジットカード番号 */
     cardyuukoukigen4keta                               VARCHAR     (4)                                                                 ,  /* クレジットカード有効期限（４桁） */
     credityuukoukakym                                  VARCHAR     (6)                                                                 ,  /* クレジットカード有効確認年月 */
     credityuukoukakkekka                               VARCHAR     (1)                                                                 ,  /* クレジットカード有効確認結果 */
     creditkigyoucd                                     VARCHAR     (5)                                                                 ,  /* クレジットカード企業コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_YuukouKakKekkaKikyk_Z ADD CONSTRAINT PK_YuukouKakKekkaKikyk PRIMARY KEY (
     creditkessaiyouno                                          /* クレジットカード決済用番号 */
) ;
