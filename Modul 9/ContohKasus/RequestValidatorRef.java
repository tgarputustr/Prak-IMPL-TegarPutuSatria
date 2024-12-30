public class RequestValidatorRef {

    public boolean validateRequest(CustomerInquiryRequest request, int customerIDFieldLength, int productFieldLength) throws BusinessException {
        validateRequestSteps(request, customerIDFieldLength, productFieldLength);
        return true;
    }

    private void validateRequestSteps(CustomerInquiryRequest request, int customerIDFieldLength, int productFieldLength) throws BusinessException {
        checkCustomerInquiryNotNullOrEmpty(request);
        checkCustomerInquiryNullOrEmpty(request);
        checkCustomerIDValid(request, customerIDFieldLength);
        checkProductNumberValid(request, productFieldLength);
    }

    private void checkCustomerInquiryNotNullOrEmpty(CustomerInquiryRequest request) throws BusinessException {
        if (request.getCustomerProduct().getProductNumber() != null && !request.getCustomerProduct().getProductNumber().isEmpty() &&
            request.getCustomer().getCustomerID() != null && !request.getCustomer().getCustomerID().isEmpty()) {
            throw new BusinessException(HandledErrors.InvalidBothParameterMessage);
        }
    }

    private void checkCustomerInquiryNullOrEmpty(CustomerInquiryRequest request) throws BusinessException {
        if ((request.getCustomer().getCustomerID() == null || request.getCustomer().getCustomerID().isEmpty()) &&
            (request.getCustomerProduct().getProductNumber() == null || request.getCustomerProduct().getProductNumber().isEmpty())) {
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        }
    }

    private void checkCustomerIDValid(CustomerInquiryRequest request, int customerIDFieldLength) throws BusinessException {
        if (request.getCustomer().getCustomerID() != null && !request.getCustomer().getCustomerID().isEmpty()) {
            if (request.getCustomer().getCustomerID().length() > customerIDFieldLength) {
                throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
            }
            request.getCustomer().setCustomerID(
                String.format("%" + customerIDFieldLength + "s", request.getCustomer().getCustomerID()).replace(' ', '0')
            );
        }
    }

    private void checkProductNumberValid(CustomerInquiryRequest request, int productFieldLength) throws BusinessException {
        if (request.getCustomerProduct().getProductNumber() != null && !request.getCustomerProduct().getProductNumber().isEmpty()) {
            if (request.getCustomerProduct().getProductNumber().length() > productFieldLength) {
                throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
            }
            request.getCustomerProduct().setProductNumber(
                String.format("%" + productFieldLength + "s", request.getCustomerProduct().getProductNumber()).replace(' ', '0')
            );
        }
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

            RequestValidatorRef validator = new RequestValidatorRef();
            boolean isValid = validator.validateRequest(request, 10, 10);

            System.out.println("Request is valid: " + isValid);
        } catch (BusinessException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}
