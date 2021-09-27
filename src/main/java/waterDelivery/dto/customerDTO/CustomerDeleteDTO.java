package waterDelivery.dto.customerDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerDeleteDTO {

    @Schema(description = "Id of the customer.",
            example = "1",
            required = true)
    private long id;
    @Schema(description = "Custumer is deleted?",
            example = "true",
            required = true)
    private Boolean isDeleted;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Boolean getDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted)
    {
        isDeleted = deleted;
    }
}
