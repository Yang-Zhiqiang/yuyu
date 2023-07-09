CREATE TABLE IW_KhKzktrkKykDrHnkWk_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     mousideninkbn                                      VARCHAR     (2)                                                                 ,  /* 申出人区分 */
     teiseikbn                                          VARCHAR     (1)                                                                 ,  /* 訂正区分 */
     trkkzkttdkkbn1                                     VARCHAR     (1)                                                                 ,  /* 登録家族手続区分１ */
     trkkzknmkn1                                        VARCHAR     (38)                                                                ,  /* 登録家族名（カナ）１ */
     trkkzknmkj1                                        VARCHAR     (32)                                                                ,  /* 登録家族名（漢字）１ */
     trkkzknmkjkhukakbn1                                VARCHAR     (1)                                                                 ,  /* 登録家族名漢字化不可区分１ */
     trkkzkseiymd1                                      VARCHAR     (8)                                                                 ,  /* 登録家族生年月日１ */
     trkkzksei1                                         VARCHAR     (1)                                                                 ,  /* 登録家族性別１ */
     trkkzkyno1                                         VARCHAR     (7)                                                                 ,  /* 登録家族郵便番号１ */
     trkkzkadr1kj1                                      VARCHAR     (62)                                                                ,  /* 登録家族住所１（漢字）１ */
     trkkzkadr2kj1                                      VARCHAR     (62)                                                                ,  /* 登録家族住所２（漢字）１ */
     trkkzkadr3kj1                                      VARCHAR     (62)                                                                ,  /* 登録家族住所３（漢字）１ */
     trkkzktelno1                                       VARCHAR     (14)                                                                ,  /* 登録家族電話番号１ */
     trkkzktdk1                                         VARCHAR     (2)                                                                 ,  /* 登録家族続柄１ */
     trkkzkttdkkbn2                                     VARCHAR     (1)                                                                 ,  /* 登録家族手続区分２ */
     trkkzknmkn2                                        VARCHAR     (38)                                                                ,  /* 登録家族名（カナ）２ */
     trkkzknmkj2                                        VARCHAR     (32)                                                                ,  /* 登録家族名（漢字）２ */
     trkkzknmkjkhukakbn2                                VARCHAR     (1)                                                                 ,  /* 登録家族名漢字化不可区分２ */
     trkkzkseiymd2                                      VARCHAR     (8)                                                                 ,  /* 登録家族生年月日２ */
     trkkzksei2                                         VARCHAR     (1)                                                                 ,  /* 登録家族性別２ */
     trkkzktdk2                                         VARCHAR     (2)                                                                 ,  /* 登録家族続柄２ */
     trkkzkyno2                                         VARCHAR     (7)                                                                 ,  /* 登録家族郵便番号２ */
     trkkzkadr1kj2                                      VARCHAR     (62)                                                                ,  /* 登録家族住所１（漢字）２ */
     trkkzkadr2kj2                                      VARCHAR     (62)                                                                ,  /* 登録家族住所２（漢字）２ */
     trkkzkadr3kj2                                      VARCHAR     (62)                                                                ,  /* 登録家族住所３（漢字）２ */
     trkkzktelno2                                       VARCHAR     (14)                                                                ,  /* 登録家族電話番号２ */
     kykdrtkykttdkkbn                                   VARCHAR     (1)                                                                 ,  /* 契約者代理特約手続区分 */
     kykdrkbn                                           VARCHAR     (2)                                                                 ,  /* 契約者代理人区分 */
     kykdairinmkn                                       VARCHAR     (38)                                                                ,  /* 契約者代理人名（カナ） */
     kykdairinmkj                                       VARCHAR     (32)                                                                ,  /* 契約者代理人名（漢字） */
     kykdrnmkjkhukakbn                                  VARCHAR     (1)                                                                 ,  /* 契約者代理人名漢字化不可区分 */
     kykdrseiymd                                        VARCHAR     (8)                                                                 ,  /* 契約者代理人生年月日 */
     kykdryno                                           VARCHAR     (7)                                                                 ,  /* 契約者代理人郵便番号 */
     kykdradr1kj                                        VARCHAR     (62)                                                                ,  /* 契約者代理人住所１（漢字） */
     kykdradr2kj                                        VARCHAR     (62)                                                                ,  /* 契約者代理人住所２（漢字） */
     kykdradr3kj                                        VARCHAR     (62)                                                                ,  /* 契約者代理人住所３（漢字） */
     shsnmkj                                            VARCHAR     (32)                                                                ,  /* 送付先氏名（漢字） */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     tyhysakuseiyhkbn                                   VARCHAR     (1)                                                                 ,  /* 帳票作成要否区分 */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     trkkzktsindousiteikbn1                             VARCHAR     (1)                                                                 ,  /* 登録家族通信先同一指定区分１ */
     trkkzktsindousiteikbn2                             VARCHAR     (1)                                                                    /* 登録家族通信先同一指定区分２ */
)
;

ALTER TABLE IW_KhKzktrkKykDrHnkWk_Z ADD CONSTRAINT PK_KhKzktrkKykDrHnkWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
