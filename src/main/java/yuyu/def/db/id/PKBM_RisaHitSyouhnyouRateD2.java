package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.mapping.GenBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.GenQBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD2;

/**
 * 利差配当商品用Ｄレートマスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RisaHitSyouhnyouRateD2}</td><td colspan="3">利差配当商品用Ｄレートマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>drate00</td><td>Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate01</td><td>Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate02</td><td>Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate03</td><td>Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate04</td><td>Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate05</td><td>Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate06</td><td>Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate07</td><td>Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate08</td><td>Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate09</td><td>Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate10</td><td>Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate11</td><td>Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate12</td><td>Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate13</td><td>Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate14</td><td>Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate15</td><td>Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate16</td><td>Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate17</td><td>Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate18</td><td>Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate19</td><td>Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate20</td><td>Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate21</td><td>Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate22</td><td>Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate23</td><td>Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate24</td><td>Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate25</td><td>Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate26</td><td>Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate27</td><td>Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate28</td><td>Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate29</td><td>Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate30</td><td>Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate31</td><td>Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate32</td><td>Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate33</td><td>Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate34</td><td>Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate35</td><td>Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate36</td><td>Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate37</td><td>Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate38</td><td>Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate39</td><td>Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate40</td><td>Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate41</td><td>Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate42</td><td>Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate43</td><td>Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate44</td><td>Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate45</td><td>Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate46</td><td>Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate47</td><td>Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate48</td><td>Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate49</td><td>Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate50</td><td>Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate51</td><td>Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate52</td><td>Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate53</td><td>Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate54</td><td>Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate55</td><td>Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate56</td><td>Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate57</td><td>Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate58</td><td>Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate59</td><td>Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate60</td><td>Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate61</td><td>Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate62</td><td>Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate63</td><td>Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate64</td><td>Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate65</td><td>Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate66</td><td>Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate67</td><td>Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate68</td><td>Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate69</td><td>Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate70</td><td>Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate71</td><td>Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate72</td><td>Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate73</td><td>Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate74</td><td>Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate75</td><td>Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate76</td><td>Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate77</td><td>Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate78</td><td>Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate79</td><td>Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate80</td><td>Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate81</td><td>Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate82</td><td>Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate83</td><td>Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate84</td><td>Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate85</td><td>Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate86</td><td>Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate87</td><td>Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate88</td><td>Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate89</td><td>Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate90</td><td>Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate91</td><td>Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate92</td><td>Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate93</td><td>Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate94</td><td>Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate95</td><td>Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate96</td><td>Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate97</td><td>Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate98</td><td>Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drate99</td><td>Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate00</td><td>Ｄ用Ｖレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate01</td><td>Ｄ用Ｖレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate02</td><td>Ｄ用Ｖレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate03</td><td>Ｄ用Ｖレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate04</td><td>Ｄ用Ｖレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate05</td><td>Ｄ用Ｖレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate06</td><td>Ｄ用Ｖレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate07</td><td>Ｄ用Ｖレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate08</td><td>Ｄ用Ｖレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate09</td><td>Ｄ用Ｖレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate10</td><td>Ｄ用Ｖレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate11</td><td>Ｄ用Ｖレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate12</td><td>Ｄ用Ｖレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate13</td><td>Ｄ用Ｖレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate14</td><td>Ｄ用Ｖレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate15</td><td>Ｄ用Ｖレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate16</td><td>Ｄ用Ｖレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate17</td><td>Ｄ用Ｖレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate18</td><td>Ｄ用Ｖレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate19</td><td>Ｄ用Ｖレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate20</td><td>Ｄ用Ｖレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate21</td><td>Ｄ用Ｖレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate22</td><td>Ｄ用Ｖレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate23</td><td>Ｄ用Ｖレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate24</td><td>Ｄ用Ｖレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate25</td><td>Ｄ用Ｖレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate26</td><td>Ｄ用Ｖレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate27</td><td>Ｄ用Ｖレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate28</td><td>Ｄ用Ｖレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate29</td><td>Ｄ用Ｖレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate30</td><td>Ｄ用Ｖレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate31</td><td>Ｄ用Ｖレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate32</td><td>Ｄ用Ｖレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate33</td><td>Ｄ用Ｖレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate34</td><td>Ｄ用Ｖレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate35</td><td>Ｄ用Ｖレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate36</td><td>Ｄ用Ｖレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate37</td><td>Ｄ用Ｖレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate38</td><td>Ｄ用Ｖレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate39</td><td>Ｄ用Ｖレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate40</td><td>Ｄ用Ｖレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate41</td><td>Ｄ用Ｖレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate42</td><td>Ｄ用Ｖレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate43</td><td>Ｄ用Ｖレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate44</td><td>Ｄ用Ｖレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate45</td><td>Ｄ用Ｖレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate46</td><td>Ｄ用Ｖレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate47</td><td>Ｄ用Ｖレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate48</td><td>Ｄ用Ｖレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate49</td><td>Ｄ用Ｖレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate50</td><td>Ｄ用Ｖレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate51</td><td>Ｄ用Ｖレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate52</td><td>Ｄ用Ｖレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate53</td><td>Ｄ用Ｖレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate54</td><td>Ｄ用Ｖレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate55</td><td>Ｄ用Ｖレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate56</td><td>Ｄ用Ｖレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate57</td><td>Ｄ用Ｖレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate58</td><td>Ｄ用Ｖレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate59</td><td>Ｄ用Ｖレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate60</td><td>Ｄ用Ｖレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate61</td><td>Ｄ用Ｖレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate62</td><td>Ｄ用Ｖレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate63</td><td>Ｄ用Ｖレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate64</td><td>Ｄ用Ｖレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate65</td><td>Ｄ用Ｖレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate66</td><td>Ｄ用Ｖレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate67</td><td>Ｄ用Ｖレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate68</td><td>Ｄ用Ｖレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate69</td><td>Ｄ用Ｖレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate70</td><td>Ｄ用Ｖレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate71</td><td>Ｄ用Ｖレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate72</td><td>Ｄ用Ｖレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate73</td><td>Ｄ用Ｖレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate74</td><td>Ｄ用Ｖレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate75</td><td>Ｄ用Ｖレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate76</td><td>Ｄ用Ｖレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate77</td><td>Ｄ用Ｖレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate78</td><td>Ｄ用Ｖレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate79</td><td>Ｄ用Ｖレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate80</td><td>Ｄ用Ｖレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate81</td><td>Ｄ用Ｖレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate82</td><td>Ｄ用Ｖレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate83</td><td>Ｄ用Ｖレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate84</td><td>Ｄ用Ｖレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate85</td><td>Ｄ用Ｖレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate86</td><td>Ｄ用Ｖレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate87</td><td>Ｄ用Ｖレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate88</td><td>Ｄ用Ｖレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate89</td><td>Ｄ用Ｖレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate90</td><td>Ｄ用Ｖレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate91</td><td>Ｄ用Ｖレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate92</td><td>Ｄ用Ｖレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate93</td><td>Ｄ用Ｖレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate94</td><td>Ｄ用Ｖレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate95</td><td>Ｄ用Ｖレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate96</td><td>Ｄ用Ｖレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate97</td><td>Ｄ用Ｖレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate98</td><td>Ｄ用Ｖレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dyouvrate99</td><td>Ｄ用Ｖレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RisaHitSyouhnyouRateD2
 * @see     GenBM_RisaHitSyouhnyouRateD2
 * @see     QBM_RisaHitSyouhnyouRateD2
 * @see     GenQBM_RisaHitSyouhnyouRateD2
 */
public class PKBM_RisaHitSyouhnyouRateD2 extends AbstractExDBPrimaryKey<BM_RisaHitSyouhnyouRateD2, PKBM_RisaHitSyouhnyouRateD2> {

    private static final long serialVersionUID = 1L;

    public PKBM_RisaHitSyouhnyouRateD2() {
    }

    public PKBM_RisaHitSyouhnyouRateD2(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPalannaihuyouriyuukbn,
        String pRatetuukasyukbn,
        String pRatedai1hknkkn,
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        palhokensyuruikigou = pPalhokensyuruikigou;
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
        palyoteiriritu = pPalyoteiriritu;
        palpmencode = pPalpmencode;
        palharaikomikaisuu = pPalharaikomikaisuu;
        palhhknsei = pPalhhknsei;
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
        palsaimankihyouji = pPalsaimankihyouji;
        palhokenkikan = pPalhokenkikan;
        palpharaikomikikan = pPalpharaikomikikan;
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
        ratetuukasyukbn = pRatetuukasyukbn;
        ratedai1hknkkn = pRatedai1hknkkn;
        paldnendo = pPaldnendo;
        paldratenaikakucode = pPaldratenaikakucode;
    }

    @Transient
    @Override
    public Class<BM_RisaHitSyouhnyouRateD2> getEntityClass() {
        return BM_RisaHitSyouhnyouRateD2.class;
    }

    private String palhokensyuruikigou;

    public String getPalhokensyuruikigou() {
        return palhokensyuruikigou;
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        palhokensyuruikigou = pPalhokensyuruikigou;
    }
    private String palhokensyuruikigousdicode;

    public String getPalhokensyuruikigousdicode() {
        return palhokensyuruikigousdicode;
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
    }
    private String palyoteiriritu;

    public String getPalyoteiriritu() {
        return palyoteiriritu;
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        palyoteiriritu = pPalyoteiriritu;
    }
    private String palpmencode;

    public String getPalpmencode() {
        return palpmencode;
    }

    public void setPalpmencode(String pPalpmencode) {
        palpmencode = pPalpmencode;
    }
    private String palharaikomikaisuu;

    public String getPalharaikomikaisuu() {
        return palharaikomikaisuu;
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        palharaikomikaisuu = pPalharaikomikaisuu;
    }
    private String palhhknsei;

    public String getPalhhknsei() {
        return palhhknsei;
    }

    public void setPalhhknsei(String pPalhhknsei) {
        palhhknsei = pPalhhknsei;
    }
    private String palkeiyakujihhknnen;

    public String getPalkeiyakujihhknnen() {
        return palkeiyakujihhknnen;
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
    }
    private String palsaimankihyouji;

    public String getPalsaimankihyouji() {
        return palsaimankihyouji;
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        palsaimankihyouji = pPalsaimankihyouji;
    }
    private String palhokenkikan;

    public String getPalhokenkikan() {
        return palhokenkikan;
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        palhokenkikan = pPalhokenkikan;
    }
    private String palpharaikomikikan;

    public String getPalpharaikomikikan() {
        return palpharaikomikikan;
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        palpharaikomikikan = pPalpharaikomikikan;
    }
    private String palannaihuyouriyuukbn;

    public String getPalannaihuyouriyuukbn() {
        return palannaihuyouriyuukbn;
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
    }
    private String ratetuukasyukbn;

    public String getRatetuukasyukbn() {
        return ratetuukasyukbn;
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        ratetuukasyukbn = pRatetuukasyukbn;
    }
    private String ratedai1hknkkn;

    public String getRatedai1hknkkn() {
        return ratedai1hknkkn;
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        ratedai1hknkkn = pRatedai1hknkkn;
    }
    private String paldnendo;

    public String getPaldnendo() {
        return paldnendo;
    }

    public void setPaldnendo(String pPaldnendo) {
        paldnendo = pPaldnendo;
    }
    private String paldratenaikakucode;

    public String getPaldratenaikakucode() {
        return paldratenaikakucode;
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        paldratenaikakucode = pPaldratenaikakucode;
    }

}