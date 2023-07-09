CREATE TABLE ZT_IjiToukeiIdouInfoTr (
     ztrsyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （取込用）証券番号 */
     ztrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* （取込用）処理年月日 */
     ztrkykmfksnctr                                     NUMBER      (7)                                                       NOT NULL  ,  /* （取込用）契約ＭＦ更新ＣＴＲ */
     ztrsyukgu                                          VARCHAR     (2)                                                                 ,  /* （取込用）種類記号 */
     ztrhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （取込用）被保険者年令（２桁） */
     ztrhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （取込用）被保険者性別区分 */
     ztrkykym                                           VARCHAR     (6)                                                                 ,  /* （取込用）契約年月 */
     ztrkisnkihons                                      NUMBER      (7)                                                                 ,  /* （取込用）計算基本Ｓ */
     ztrimustiyusbus                                    NUMBER      (7)                                                                 ,  /* （取込用）医務査定用死亡Ｓ */
     ztrshrs                                            NUMBER      (7)                                                                 ,  /* （取込用）支払Ｓ */
     ztrshrymd                                          VARCHAR     (8)                                                                 ,  /* （取込用）支払年月日 */
     ztrsymtgenincd                                     VARCHAR     (3)                                                                 ,  /* （取込用）消滅原因コード */
     ztrkeikaym                                         VARCHAR     (4)                                                                 ,  /* （取込用）経過年月 */
     ztrsbugenincd                                      VARCHAR     (3)                                                                 ,  /* （取込用）死亡原因コード */
     ztrbsyym                                           VARCHAR     (6)                                                                 ,  /* （取込用）募集年月 */
     ztrdai2hhknnen                                     VARCHAR     (2)                                                                 ,  /* （取込用）第２被保険者年令 */
     ztrmannenreihyj                                    VARCHAR     (1)                                                                 ,  /* （取込用）満年令表示 */
     ztrtignmrtisyukgu                                  VARCHAR     (2)                                                                 ,  /* （取込用）逓減マル定種類記号 */
     ztrhhknnentysihyj                                  VARCHAR     (1)                                                                 ,  /* （取込用）被保険者年令調整表示 */
     ztrdai2hhknnentysihyj                              VARCHAR     (1)                                                                 ,  /* （取込用）第２被保険者年令調整表示 */
     ztrrenseimrtisyukgu                                VARCHAR     (2)                                                                 ,  /* （取込用）連生マル定種類記号 */
     ztrbnktjitiktkarihyj                               VARCHAR     (1)                                                                 ,  /* （取込用）分割時定期特約有表示 */
     ztrlivingneedsshrarihyj                            VARCHAR     (1)                                                                 ,  /* （取込用）リビングニーズ支払有表示 */
     ztrlnkeikaym                                       VARCHAR     (4)                                                                 ,  /* （取込用）ＬＮ経過年月 */
     ztrlnshrgenincd                                    VARCHAR     (4)                                                                 ,  /* （取込用）ＬＮ支払原因コード */
     ztrkituenkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）喫煙区分 */
     ztrkituenhonsuu                                    VARCHAR     (2)                                                                 ,  /* （取込用）喫煙本数 */
     ztrgnspshrhyj                                      VARCHAR     (1)                                                                 ,  /* （取込用）がんサポ支払表示 */
     ztrgnspshrkeikaym                                  VARCHAR     (4)                                                                 ,  /* （取込用）がんサポ支払経過年月 */
     ztrgnspshrgenincd                                  VARCHAR     (4)                                                                 ,  /* （取込用）がんサポ支払原因コード */
     ztrsyunyumrtisyukgu                                VARCHAR     (2)                                                                 ,  /* （取込用）収入マル定種類記号 */
     ztrsysnymd                                         VARCHAR     (8)                                                                 ,  /* （取込用）初診年月日 */
     ztrsindanymd                                       VARCHAR     (8)                                                                 ,  /* （取込用）診断年月日 */
     ztrbyoumeicd1                                      VARCHAR     (4)                                                                 ,  /* （取込用）病名コード１ */
     ztrbyoumeicd2                                      VARCHAR     (4)                                                                 ,  /* （取込用）病名コード２ */
     ztrshrnaiyoukbn                                    VARCHAR     (1)                                                                 ,  /* （取込用）支払内容区分 */
     ztrgituyuknkbn1                                    VARCHAR     (1)                                                                 ,  /* （取込用）該当要件区分１ */
     ztrgituyuknkbn2                                    VARCHAR     (1)                                                                 ,  /* （取込用）該当要件区分２ */
     ztrsyeiebnri1                                      VARCHAR     (1)                                                                 ,  /* （取込用）シェイエ分類１ */
     ztrsyeiebnri2                                      VARCHAR     (1)                                                                 ,  /* （取込用）シェイエ分類２ */
     ztrminnesotacd1                                    VARCHAR     (2)                                                                 ,  /* （取込用）ミネソタコード１ */
     ztrminnesotacd2                                    VARCHAR     (2)                                                                 ,  /* （取込用）ミネソタコード２ */
     ztrminnesotacd3                                    VARCHAR     (2)                                                                 ,  /* （取込用）ミネソタコード３ */
     ztrminnesotacd4                                    VARCHAR     (2)                                                                 ,  /* （取込用）ミネソタコード４ */
     ztrminnesotacd5                                    VARCHAR     (2)                                                                 ,  /* （取込用）ミネソタコード５ */
     ztrmnsisiensindanjiyuu                             VARCHAR     (1)                                                                 ,  /* （取込用）慢性膵炎診断事由 */
     ztrknkuhnsindanjiyuu                               VARCHAR     (1)                                                                 ,  /* （取込用）肝硬変診断事由 */
     ztrhushrkbn                                        VARCHAR     (1)                                                                 ,  /* （取込用）不支払区分 */
     ztrhushrym                                         VARCHAR     (6)                                                                 ,  /* （取込用）不支払年月 */
     ztrsyuurouhunoukghasseiymd                         VARCHAR     (8)                                                                 ,  /* （取込用）就労不能介護傷病発生年月日 */
     ztrsyuurouhunoukgjyoutaikbn                        VARCHAR     (1)                                                                 ,  /* （取込用）就労不能介護状態区分 */
     ztrhokoukahikbn                                    VARCHAR     (1)                                                                 ,  /* （取込用）歩行可否区分 */
     ztrngerkahikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）寝返り可否区分 */
     ztrihukutyakudatukahikbn                           VARCHAR     (1)                                                                 ,  /* （取込用）衣服着脱可否区分 */
     ztrnyykkahikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）入浴可否区分 */
     ztrsykmtssyukahikbn                                VARCHAR     (1)                                                                 ,  /* （取込用）食物摂取可否区分 */
     ztrfktrsmtkahikbn                                  VARCHAR     (1)                                                                 ,  /* （取込用）拭き取り始末可否区分 */
     ztrseiketuseiyoukahikbn                            VARCHAR     (1)                                                                 ,  /* （取込用）清潔整容可否区分 */
     ztrsyuurouhunoujyoutaikbn                          VARCHAR     (2)                                                                 ,  /* （取込用）就労不能状態区分 */
     ztrkyuuseisinkinkousokukbn                         VARCHAR     (1)                                                                 ,  /* （取込用）急性心筋梗塞区分 */
     ztrnousottyuukbn                                   VARCHAR     (1)                                                                 ,  /* （取込用）脳卒中区分 */
     ztrjinhuzenkbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）腎不全区分 */
     ztrhukasyuksyu                                     VARCHAR     (1)                                                                 ,  /* （取込用）付加主契約種類 */
     ztrtkkbn2                                          VARCHAR     (2)                                                                 ,  /* （取込用）特約区分（２文字） */
     ztrdoumyakusikkankbn                               VARCHAR     (1)                                                                 ,  /* （取込用）動脈疾患区分 */
     ztrsykikjgykbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）職域事業区分 */
     ztrkaijyokbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）解除区分 */
     ztrsymtymd                                         VARCHAR     (8)                                                                 ,  /* （取込用）消滅年月日 */
     ztrtyuutohukatkhyj                                 VARCHAR     (1)                                                                 ,  /* （取込用）中途付加特約表示 */
     ztryoukigjyutigituymd                              VARCHAR     (8)                                                                 ,  /* （取込用）要介護状態該当年月日 */
     ztryoukigjyutigeninkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）要介護状態原因区分 */
     ztrtihougeninkbn                                   VARCHAR     (1)                                                                 ,  /* （取込用）痴呆原因区分 */
     ztrsyukgusdkbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）種類記号世代区分 */
     ztrtignmrtisyukgusdkbn                             VARCHAR     (1)                                                                 ,  /* （取込用）逓減マル定種類記号世代区分 */
     ztrrenseimrtisyukgusdkbn                           VARCHAR     (1)                                                                 ,  /* （取込用）連生マル定種類記号世代区分 */
     ztrsyunyumrtisyukgusdkbn                           VARCHAR     (1)                                                                 ,  /* （取込用）収入マル定種類記号世代区分 */
     ztrsbtoukeiidouinfopmenkbn                         VARCHAR     (2)                                                                 ,  /* （取込用）死亡統計異動情報Ｐ免区分 */
     ztrpmenjikohasseiymd                               VARCHAR     (8)                                                                 ,  /* （取込用）Ｐ免事故発生年月日 */
     ztrsyorino2moji                                    VARCHAR     (2)                                                                 ,  /* （取込用）処理番号（２文字） */
     ztrksnym                                           VARCHAR     (6)                                                                 ,  /* （取込用）更新年月 */
     ztrikoujisnskbn                                    VARCHAR     (1)                                                                 ,  /* （取込用）移行時診査区分 */
     ztrsysnikoujiym                                    VARCHAR     (6)                                                                 ,  /* （取込用）終身移行時年月 */
     ztrijitoukeiyuksnhyj                               VARCHAR     (1)                                                                 ,  /* （取込用）医事統計用更新表示 */
     ztrsotodasiphkbnmnoshyouji                         VARCHAR     (1)                                                                 ,  /* （取込用）外出Ｐ不可分見直表示 */
     ztrstdsstkjytkyuhyj                                VARCHAR     (1)                                                                 ,  /* （取込用）外出新特条適用表示 */
     ztrstdssytikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）外出集定区分 */
     ztrbnktgosnzkkyksyono                              VARCHAR     (11)                                                                ,  /* （取込用）分割後存続契約証券番号 */
     ztrbnkttnknkbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）分割転換区分 */
     ztrkykjiqpackhyj                                   VARCHAR     (1)                                                                 ,  /* （取込用）契約時Ｑパック表示 */
     ztrbnktjisisttkarihyj                              VARCHAR     (1)                                                                 ,  /* （取込用）分割時災疾特約有表示 */
     ztrsotodasipmenkbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）外出Ｐ免区分 */
     ztrstdssnskbn                                      VARCHAR     (1)                                                                 ,  /* （取込用）外出診査区分 */
     ztryobisuuti7x1                                    NUMBER      (7)                                                                 ,  /* （取込用）予備数値７＿１ */
     ztryobisuuti7x2                                    NUMBER      (7)                                                                 ,  /* （取込用）予備数値７＿２ */
     ztryobimojihan15                                   VARCHAR     (15)                                                                ,  /* （取込用）予備文字半角１５ */
     ztryobimojihan51                                   VARCHAR     (51)                                                                ,  /* （取込用）予備文字半角５１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_IjiToukeiIdouInfoTr ADD CONSTRAINT PK_IjiToukeiIdouInfoTr PRIMARY KEY (
     ztrsyono                                                 , /* （取込用）証券番号 */
     ztrkykmfksnctr                                             /* （取込用）契約ＭＦ更新ＣＴＲ */
) ;
