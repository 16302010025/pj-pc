package education.entity.wx;

import org.apache.ibatis.annotations.Insert;

public class WXNote {
  private Integer kpID;
  private String kpName;
  private Integer noteID;
  private String description;

  public Integer getKpID() {
    return kpID;
  }

  public void setKpID(Integer kpID) {
    this.kpID = kpID;
  }

  public String getKpName() {
    return kpName;
  }

  public void setKpName(String kpName) {
    this.kpName = kpName;
  }

  public Integer getNoteID() {
    return noteID;
  }

  public void setNoteID(Integer noteID) {
    this.noteID = noteID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
