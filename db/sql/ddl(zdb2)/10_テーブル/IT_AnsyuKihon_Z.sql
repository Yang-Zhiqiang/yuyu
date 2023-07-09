CREATE TABLE IT_AnsyuKihon_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     tkiktannaitukisuu                                  VARCHAR     (2)                                                                 ,  /* 定期一括案内月数 */
     kjsmhakkouzumiflg                                  VARCHAR     (1)                                                                 ,  /* 控除証明書発行済フラグ */
     syuharaimanymd                                     VARCHAR     (8)                                                                 ,  /* 主契約払満日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_AnsyuKihon_Z ADD CONSTRAINT PK_AnsyuKihon PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_AnsyuKihon ON IT_AnsyuKihon_Z (
     jkipjytym                                                  /* 次回Ｐ充当年月 */
) ;

CREATE INDEX IX2_AnsyuKihon ON IT_AnsyuKihon_Z (
     syono                                                      /* 証券番号 */
) ;
