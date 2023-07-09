CREATE TABLE IW_KhMeigiHenkouWk_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     meigihnkjiyuu                                      VARCHAR     (1)                                                                 ,  /* 名義変更事由 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyknmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 契約者名漢字化不可区分 */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     kkkyktdk                                           VARCHAR     (2)                                                                 ,  /* 契約管理契約者続柄 */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkjkhukakbn                                   VARCHAR     (1)                                                                 ,  /* 被保険者名漢字化不可区分 */
     nenkinuktkbn                                       VARCHAR     (2)                                                                 ,  /* 年金受取人区分 */
     sbuktnin                                           DECIMAL     (2)                                                                 ,  /* 死亡受取人人数 */
     sbuktkaijyokbn1                                    VARCHAR     (1)                                                                 ,  /* 死亡受取人解除区分１ */
     sbuktkbn1                                          VARCHAR     (2)                                                                 ,  /* 死亡受取人区分１ */
     sbuktnmkn1                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）１ */
     sbuktnmkj1                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）１ */
     sbuktnmkjhukakbn1                                  VARCHAR     (1)                                                                 ,  /* 死亡受取人名漢字化不可区分１ */
     sbuktseiymd1                                       VARCHAR     (8)                                                                 ,  /* 死亡受取人生年月日１ */
     sbuktbnwari1                                       DECIMAL     (3)                                                                 ,  /* 死亡受取人分割割合１ */
     sbuktkaijyokbn2                                    VARCHAR     (1)                                                                 ,  /* 死亡受取人解除区分２ */
     sbuktkbn2                                          VARCHAR     (2)                                                                 ,  /* 死亡受取人区分２ */
     sbuktnmkn2                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）２ */
     sbuktnmkj2                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）２ */
     sbuktnmkjhukakbn2                                  VARCHAR     (1)                                                                 ,  /* 死亡受取人名漢字化不可区分２ */
     sbuktseiymd2                                       VARCHAR     (8)                                                                 ,  /* 死亡受取人生年月日２ */
     sbuktbnwari2                                       DECIMAL     (3)                                                                 ,  /* 死亡受取人分割割合２ */
     sbuktkaijyokbn3                                    VARCHAR     (1)                                                                 ,  /* 死亡受取人解除区分３ */
     sbuktkbn3                                          VARCHAR     (2)                                                                 ,  /* 死亡受取人区分３ */
     sbuktnmkn3                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）３ */
     sbuktnmkj3                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）３ */
     sbuktnmkjhukakbn3                                  VARCHAR     (1)                                                                 ,  /* 死亡受取人名漢字化不可区分３ */
     sbuktseiymd3                                       VARCHAR     (8)                                                                 ,  /* 死亡受取人生年月日３ */
     sbuktbnwari3                                       DECIMAL     (3)                                                                 ,  /* 死亡受取人分割割合３ */
     sbuktkaijyokbn4                                    VARCHAR     (1)                                                                 ,  /* 死亡受取人解除区分４ */
     sbuktkbn4                                          VARCHAR     (2)                                                                 ,  /* 死亡受取人区分４ */
     sbuktnmkn4                                         VARCHAR     (38)                                                                ,  /* 死亡受取人名（カナ）４ */
     sbuktnmkj4                                         VARCHAR     (32)                                                                ,  /* 死亡受取人名（漢字）４ */
     sbuktnmkjhukakbn4                                  VARCHAR     (1)                                                                 ,  /* 死亡受取人名漢字化不可区分４ */
     sbuktseiymd4                                       VARCHAR     (8)                                                                 ,  /* 死亡受取人生年月日４ */
     sbuktbnwari4                                       DECIMAL     (3)                                                                 ,  /* 死亡受取人分割割合４ */
     stdrskkaijyokbn                                    VARCHAR     (1)                                                                 ,  /* 指定代理請求人解除区分 */
     stdruktkbn                                         VARCHAR     (2)                                                                 ,  /* 指定代理受取人区分 */
     stdrsknmkn                                         VARCHAR     (38)                                                                ,  /* 指定代理請求人名（カナ） */
     stdrsknmkj                                         VARCHAR     (32)                                                                ,  /* 指定代理請求人名（漢字） */
     stdrsknmkjhukakbn                                  VARCHAR     (1)                                                                 ,  /* 指定代理請求人名漢字化不可区分 */
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
     adrhenkouumu                                       VARCHAR     (1)                                                                 ,  /* 住所変更有無 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     oldkyksibouymd                                     VARCHAR     (8)                                                                 ,  /* （旧）契約者死亡日 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     stdrskseiymd                                       VARCHAR     (8)                                                                    /* 指定代理請求人生年月日 */
)
;

ALTER TABLE IW_KhMeigiHenkouWk_Z ADD CONSTRAINT PK_KhMeigiHenkouWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
