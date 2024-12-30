public class RequestValidator {

    public boolean validateRequest(CustomerInquiryRequest request, int customerIDFieldLength, int productFieldLength) throws BusinessException {
        if (request.getCustomerProduct().getProductNumber() != null && request.getCustomer().getCustomerID() != null) {
            if (!request.getCustomerProduct().getProductNumber().isEmpty() && !request.getCustomer().getCustomerID().isEmpty()) {
                // Both were populated
                throw new BusinessException(HandledErrors.InvalidBothParameterMessage);
            } else if (request.getCustomer().getCustomerID().isEmpty() && request.getCustomerProduct().getProductNumber().isEmpty()) {
                // If objects were instantiated but not populated
                throw new BusinessException(HandledErrors.CustomerEmptyMessage);
            } else if (!request.getCustomer().getCustomerID().isEmpty()) {
                // ProductNumber was empty; check CustomerID length
                if (request.getCustomer().getCustomerID().length() > customerIDFieldLength) {
                    throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
                }
            } else {
                // CustomerID was empty; check ProductNumber length
                if (request.getCustomerProduct().getProductNumber().length() > productFieldLength) {
                    throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
                }
            }
        } else if (request.getCustomerProduct().getProductNumber() == null && request.getCustomer().getCustomerID() == null) {
            // Both were null
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        } else if (request.getCustomerProduct().getProductNumber() == null) {
            // ProductNumber was null; check CustomerID length
            if (request.getCustomer().getCustomerID().length() > customerIDFieldLength) {
                throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
            }
        } else {
            // ProductNumber not null; check ProductNumber length
            if (request.getCustomerProduct().getProductNumber().length() > productFieldLength) {
                throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
            }
        }

        // Set objects below with formatted data (e.g., PadLeft)
        if (request.getCustomer().getCustomerID() != null) {
            request.getCustomer().setCustomerID(
                String.format("%" + customerIDFieldLength + "s", request.getCustomer().getCustomerID()).replace(' ', '0')
            );
        }
        if (request.getCustomerProduct().getProductNumber() != null) {
            request.getCustomerProduct().setProductNumber(
                String.format("%" + productFieldLength + "s", request.getCustomerProduct().getProductNumber()).replace(' ', '0')
            );
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Customer customer = new Customer();
            customer.setCustomerID("12345");
    
            CustomerProduct customerProduct = new CustomerProduct();
            customerProduct.setProductNumber("67890");
    
            CustomerInquiryRequest request = new CustomerInquiryRequest();
            request.setCustomer(customer);
            request.setCustomerProduct(customerProduct);
    
            RequestValidator validator = new RequestValidator();
            boolean isValid = validator.validateRequest(request, 10, 10);
    
            System.out.println("Request is valid: " + isValid);
        } catch (BusinessException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
    
}
